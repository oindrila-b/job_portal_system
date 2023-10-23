package com.example.jobportal.exceptions;
/*****
 *This exception is thrown when the request body parameters are null.
 * **/
public class RequestParameterNullException extends Exception{
    public RequestParameterNullException(String message) {
        super(message);
    }
}