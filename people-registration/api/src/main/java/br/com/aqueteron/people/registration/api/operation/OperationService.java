package br.com.aqueteron.people.registration.api.operation;

import br.com.aqueteron.people.registration.api.exception.BusinessException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OperationService {

    private final RabbitTemplate rabbitTemplate;

    private final FanoutExchange operationExchange;

    private final ObjectMapper objectMapper;

    public void sendOperation(final Operation operation) {
        try {
            this.rabbitTemplate.convertAndSend(operationExchange.getName(), "", this.objectMapper.writeValueAsString(operation));
        } catch (JsonProcessingException e) {
            throw new BusinessException(HttpStatus.BAD_GATEWAY, e.getMessage(), e);
        }
    }
}
