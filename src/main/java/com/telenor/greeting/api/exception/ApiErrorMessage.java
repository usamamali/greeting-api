package com.telenor.greeting.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

/**
 * @author usama
 */

@AllArgsConstructor
@Getter
public class ApiErrorMessage {
    private ZonedDateTime time;
    private int httpStatus;
    private String message;
}
