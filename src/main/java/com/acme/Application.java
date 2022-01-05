package com.acme;

import com.acme.decorators.BaseServerStatus;
import com.acme.facades.SystemFacade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Standard main class for Spring, generated by Spring template
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        BaseServerStatus.setFacade(new SystemFacade());
        SpringApplication.run(Application.class, args);
    }
}
