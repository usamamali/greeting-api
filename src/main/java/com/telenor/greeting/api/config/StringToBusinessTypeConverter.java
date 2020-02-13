package com.telenor.greeting.api.config;

import com.telenor.greeting.api.entity.BusinessType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

/**
 * @author usama
 */

@Slf4j
public class StringToBusinessTypeConverter implements Converter<String, BusinessType> {

    @Override
    public BusinessType convert(String source) {
        try {
            return BusinessType.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
            throw new IllegalArgumentException(String.format("%s is not a possible Business type", source));
        }
    }
}
