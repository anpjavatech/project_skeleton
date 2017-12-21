package com.xylem.dewatering.fst.controller.exception;
/**
 * Created by Anoop.ks on 11-12-2017
 */
public class HttpException extends RuntimeException {

    public final int statusCode;
    public final String description;
    public final int errorCode;

    public HttpException(int statusCode, String description, int errorCode) {
        this.statusCode = statusCode;
        this.description = description;
        this.errorCode = errorCode;
    }

      public HttpException(int statusCode, String description, int errorCode, Throwable throwable) {
        super(description, throwable);
        this.statusCode = statusCode;
        this.description = description;
        this.errorCode = errorCode;
    }

    public HttpException(ApiError error){
        this(error, error.defaultMessage);
    }

    public HttpException(ApiError error, String message){
        this(error,message, null);
    }

    public HttpException(ApiError error, String message, Throwable cause){
        this(error.httpStatusCode, message, error.code, cause);
    }
}
