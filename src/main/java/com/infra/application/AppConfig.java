package com.infra.application;

import com.infra.application.converter.StringToDateTimestampConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class AppConfig {

    public ConversionService getConversionService() {
        ConversionServiceFactoryBean conversionService = new ConversionServiceFactoryBean();
        conversionService.setConverters(getConverterSet());
        return conversionService.getObject();
    }

    private Set<Converter> getConverterSet() {
        Set<Converter> converterSet = new HashSet<>();
        converterSet.add(new StringToDateTimestampConverter());
        return converterSet;
    }
}
