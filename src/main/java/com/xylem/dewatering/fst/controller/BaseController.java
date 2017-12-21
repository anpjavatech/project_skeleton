package com.xylem.dewatering.fst.controller;
/**
 * Created by Anoop.ks on 11-12-2017
 */
import com.xylem.dewatering.fst.controller.exception.ApiErrorCodes;
import com.xylem.dewatering.fst.controller.exception.HttpException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

public class BaseController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    protected static class HttpExceptionJson {
        public final String incidentID;
        public final int errorCode;
        @JsonInclude(Include.NON_EMPTY)
        public final String description;

        public HttpExceptionJson(int errorCode, String description) {
            this.incidentID = UUID.randomUUID().toString();
            this.errorCode = errorCode;
            this.description = description;
        }
    }

    @ExceptionHandler(HttpException.class)
    @ResponseBody
    public ResponseEntity<HttpExceptionJson> HandleAndLogHttpException(HttpException e) {
        HttpExceptionJson httpExceptionJson = new HttpExceptionJson(e.errorCode, e.description);
        String errorMsg = String.format("IncidentID - %s (%s) %s", httpExceptionJson.incidentID, e.errorCode, e.description);
        if (e.getCause() != null)
            logger.error(errorMsg, e.getCause());
        else
            logger.error(errorMsg);
        return new ResponseEntity<>(httpExceptionJson, HttpStatus.valueOf(e.statusCode));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public @ResponseBody
    ResponseEntity<HttpExceptionJson> handleValidationException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        sb.append("Validation Errors: ");

        // create a string containing what fields contained what errors
        List<FieldError> errors = e.getBindingResult().getFieldErrors();

        for (int i = 0; i < errors.size(); i++) {
            FieldError error = errors.get(i);
            sb.append(String.format("%s %s", error.getField(), error.getDefaultMessage()));

            if (i != errors.size() - 1)
                sb.append(", ");
            else
                sb.append(".");
        }

        return HandleAndLogHttpException(new HttpException(ApiErrorCodes.VALIDATION_ERRORS, sb.toString()));
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<HttpExceptionJson> handleAnyException(Exception e) {
        return HandleAndLogHttpException(new HttpException(ApiErrorCodes.UNKNOWN, e.getMessage()));
    }

}
