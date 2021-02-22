<<<<<<< Updated upstream
package com.infra.application.start;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Application startup using spring boot
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {"com.infra"})
public class FileServiceAppStart {

    public static void main(String[] args) {
        System.out.println("APPLICATION STARTED SUCCESSFULLY ");

        //customize spring boot startup
        ConfigurableApplicationContext springContext = new SpringApplicationBuilder(FileServiceAppStart.class)
                .properties("spring.config.name:application", "spring.config.location:classpath:/env/")
                .build()
                .run(args);

        log.info("!!! Application started successfully with spring.profiles.active=" + System.getProperty("spring.profiles.active") + "!!!");
    }
}
=======
package com.infra.application.start;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application startup using spring boot
 */
@Slf4j
//used to exclude loading Hibernate/JPA/Entity beans at startup
//@SpringBootApplication(scanBasePackages = {"com.infra"}, exclude = HibernateJpaAutoConfiguration.class)
@SpringBootApplication(scanBasePackages = {"com.infra"})
@EntityScan(basePackages = {"com.infra"})
@EnableJpaRepositories(basePackages = {"com.infra"})
public class FileServiceAppStart {

    public static void main(String[] args) {
        System.out.println("Starting Application.....");

        //customize spring boot startup
        ConfigurableApplicationContext springContext = new SpringApplicationBuilder(FileServiceAppStart.class)
                .properties("spring.config.name:application", "spring.config.location:classpath:/env/")
                .build()
                .run(args);

        log.info("!!! Application started successfully with spring.profiles.active=" + System.getProperty("spring.profiles.active") + "!!!");
    }
}
>>>>>>> Stashed changes
