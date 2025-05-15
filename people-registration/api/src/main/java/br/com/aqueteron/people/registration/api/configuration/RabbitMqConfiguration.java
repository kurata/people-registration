package br.com.aqueteron.people.registration.api.configuration;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    @Bean
    public FanoutExchange operationExchange() {
        return new FanoutExchange("people-registration.operation");
    }

}
