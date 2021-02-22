package com.infra.web.integrationtest;

import com.infra.adapters.web.file.controller.FileDetailServiceImpl;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@PropertySource("classpath:application-test.properties")
@Ignore
public class FileServiceAppStartTest {

//    @Autowired
//    private PropertySourcesPropertyResolver propertySourceResolver;

    public @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() { return new PropertySourcesPlaceholderConfigurer(); }

    @Autowired
    private FileDetailServiceImpl fileDetailService;

    @Value("${server.port}")
    String serverPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Ignore
    public void testPropOverride() {
//        String port = propertySourceResolver.getProperty("server.port");
//        System.out.println ("ServerPort: " + port);
        Assert.assertEquals("Checking serverPort properties override using prop file.", "10001", serverPort);
    }
}
