package br.com.aqueteron.people.registration.api.operation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class OperationPersistenceReceiver {

    private final OperationRepository operationRepository;

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "operationQueue")
    public void receiveOperation(final String operationString) {
        log.debug("Received operation: {}", operationString);
        try {
            Operation operation = this.objectMapper.readValue(operationString, Operation.class);
            this.operationRepository.save(operation);
            log.debug("Saved operation: {}", operationString);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }
}
