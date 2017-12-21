package com.xylem.dewatering.fst.controller.exception;

/**
 * Created by Anoop.ks on 11-12-2017
 */

public class ApiErrorCodes {
    public static final ApiError INVALID_REQUEST = err(400, 400,"Invalid Request");
    public static final ApiError VALIDATION_ERRORS = err(400, 400, "Validation errors");
    public static final ApiError UNKNOWN = err(500, 500, "Unknown error occurred");
    public static final ApiError FORBIDDEN = err(403, 403, "Forbidden");
    public static final ApiError NOT_FOUND = err(404, 404, "Not found");

    private ApiErrorCodes() {}

    protected static ApiError err(int code, int httpStatusCode, String defaultMessage){
        return new ApiError(code, httpStatusCode, defaultMessage);
    }

}
