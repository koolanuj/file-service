package com.infra.application.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class StringToDateTimestampConverter implements Converter<String, LocalDateTime> {

    public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
    DateTimeFormatter formatterFullDate = DateTimeFormatter.ofPattern(DATE_FORMAT_FULL);
    /**
     * Convert the source object of type {@code String} to target type {@code LocalDateTime}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public LocalDateTime convert(String source) {
        //return LocalDateTime.parse(source, formatterFullDate);
        return LocalDateTime.parse(source, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
