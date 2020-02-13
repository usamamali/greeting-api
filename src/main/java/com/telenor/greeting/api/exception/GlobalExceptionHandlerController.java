package com.telenor.greeting.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.ZonedDateTime;

/**
 * @author usama
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandlerController {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    ApiErrorMessage handleConstraintViolationException(ConstraintViolationException e) {
        log.error(e.getMessage(), e);
        String errMessage = e.getConstraintViolations().stream().findFirst().map(ConstraintViolation::getMessage).orElse("unknown reason");
        return new ApiErrorMessage(ZonedDateTime.now(), HttpStatus.BAD_REQUEST.value(), errMessage);
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler(value = {NotImplementedPathException.class})
    public ApiErrorMessage handleNotImplementedPathException(NotImplementedPathException e) {
        log.error(e.getMessage(), e);
        return new ApiErrorMessage(ZonedDateTime.now(), HttpStatus.NOT_IMPLEMENTED.value(), e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConversionFailedException.class)
    ApiErrorMessage handleConversionFailedException(ConversionFailedException e) {
        log.error(e.getMessage(), e);
        return new ApiErrorMessage(ZonedDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getCause().getMessage());
    }
}
