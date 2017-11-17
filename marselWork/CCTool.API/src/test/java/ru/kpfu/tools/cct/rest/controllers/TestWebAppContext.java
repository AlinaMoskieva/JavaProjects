package ru.kpfu.tools.cct.rest.controllers;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kpfu.tools.cct.core.services.WorkerServiceFacade;

@Configuration
public class TestWebAppContext {

    @Bean
    public WorkerServiceFacade userServiceFacade() {
        return Mockito.mock(WorkerServiceFacade.class);
    }
}
