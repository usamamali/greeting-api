package com.telenor.greeting.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.ZonedDateTime;

/**
 * @author usama
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandlerController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    ApiErrorMessage handleConstraintViolationException(ConstraintViolationException e) {
        log.error(e.getMessage(), e);
        String errMessage = e.getConstraintViolations().stream().findFirst().map(ConstraintViolation::getMessage).orElse("unknown reason");
        return new ApiErrorMessage(ZonedDateTime.now(), HttpStatus.BAD_REQUEST.value(), errMessage);
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler(NotImplementedPathException.class)
    public ApiErrorMessage handleNotImplementedPathException(NotImplementedPathException e) {
        log.error(e.getMessage(), e);
        return new ApiErrorMessage(ZonedDateTime.now(), HttpStatus.NOT_IMPLEMENTED.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ConversionFailedException.class, IllegalArgumentException.class, MethodArgumentTypeMismatchException.class})
    ApiErrorMessage handleConversionFailedException(ConversionFailedException e) {
        log.error(e.getMessage(), e);
        return new ApiErrorMessage(ZonedDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getCause().getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ApiErrorMessage handleGeneralExceptions(Exception e) {
        log.error(e.getMessage(), e);
        return new ApiErrorMessage(ZonedDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Error. Please, try again later");
    }
}
