package br.com.aqueteron.people.registration.api.configuration;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ObservabilityConfiguration {

    @Bean
    public ObservedAspect observedAspect(final ObservationRegistry observationRegistry){
        return new ObservedAspect(observationRegistry);
    }

}
