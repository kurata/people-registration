package br.com.aqueteron.people.registration.api.operation;

import br.com.aqueteron.people.registration.api.exception.BusinessException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OperationServiceTest {

    @InjectMocks
    private OperationService operationService;

    @Mock
    private RabbitTemplate rabbitTemplate;

    @Mock
    private FanoutExchange fanoutExchange;

    @Mock
    private ObjectMapper objectMapper;

    @Test
    void shouldSendOperation() throws JsonProcessingException {
        Operation operation = OperationStubs.createNewOperation();
        when(fanoutExchange.getName()).thenReturn("fanoutName");
        when(objectMapper.writeValueAsString(operation)).thenReturn("operationValueString");

        operationService.sendOperation(operation);
        verify(this.rabbitTemplate).convertAndSend("fanoutName", "", "operationValueString");
    }

    @Test
    void shouldSendOperationCatchJsonProcessingException() throws JsonProcessingException {
        Operation operation = OperationStubs.createNewOperation();
        when(fanoutExchange.getName()).thenReturn("fanoutName");
        when(objectMapper.writeValueAsString(operation)).thenThrow(JsonProcessingException.class);

        assertThrows(BusinessException.class, () -> operationService.sendOperation(operation));
    }
}
