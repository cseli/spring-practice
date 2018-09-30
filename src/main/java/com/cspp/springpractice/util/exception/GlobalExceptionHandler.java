package com.cspp.springpractice.util.exception;

import com.cspp.springpractice.util.exception.exception.CarNotFoundException;
import com.cspp.springpractice.util.exception.response.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public ErrorResponse invalidParameter() {
        return new ErrorResponse(BAD_REQUEST.toString(), "Invalid parameter(s)");
    }


    @ExceptionHandler(CarNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public ErrorResponse carNotFound(CarNotFoundException e) {
        return new ErrorResponse(NOT_FOUND.toString(), "Something went wrong...");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse somethingWentWrong(Exception e) {
        return new ErrorResponse(INTERNAL_SERVER_ERROR.toString(), "Something went wrong...");
    }
}
