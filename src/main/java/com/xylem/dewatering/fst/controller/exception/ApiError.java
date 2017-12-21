package com.xylem.dewatering.fst.controller.exception;

/**
 * Created by Anoop.ks on 11-12-2017
 */

public final class ApiError {

    public final int code;
    public final int httpStatusCode;
    public final String defaultMessage;

    public ApiError(int code, int httpStatusCode, String defaultMessage) {
        this.code = code;
        this.httpStatusCode = httpStatusCode;
        this.defaultMessage = defaultMessage;
    }
}
