package com.varun.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.varun.ApplicationRunner;
import com.varun.domain.repository.ChgRequestRepository;
import com.varun.domain.service.ChgRequestService;
import com.varun.domain.service.ChgRequestServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = ApplicationRunner.class)
public class BeanConfiguration {

    @Bean
    ChgRequestService orderService(final ChgRequestRepository chgRequestRepository) {
        return new ChgRequestServiceImpl(chgRequestRepository);
    }
}
