package com.xylem.dewatering.fst.controller;
/**
 * Created by Anoop.ks on 11-12-2017
 */
import com.xylem.dewatering.fst.controller.exception.HttpException;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class JsonErrorController extends BaseController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @ResponseBody
    @RequestMapping(value = "/error")
    public ResponseEntity<HttpExceptionJson> error(HttpServletRequest request){
        int status = (int) request.getAttribute("javax.servlet.error.status_code");
        return HandleAndLogHttpException(new HttpException(status, HttpStatus.valueOf(status).getReasonPhrase(),status));
    }
}
