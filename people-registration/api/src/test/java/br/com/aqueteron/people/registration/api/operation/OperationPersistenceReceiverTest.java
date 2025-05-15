package br.com.aqueteron.people.registration.api.operation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OperationPersistenceReceiverTest {

    @InjectMocks
    private OperationPersistenceReceiver receiver;

    @Mock
    private OperationRepository operationRepository;

    @Mock
    private ObjectMapper objectMapper;

    @Test
    void shouldReceiveOperation() throws JsonProcessingException {
        String operationString = "operationString";
        Operation operation = OperationStubs.createNewOperation();

        when(this.objectMapper.readValue(operationString, Operation.class)).thenReturn(operation);
        this.receiver.receiveOperation(operationString);
        verify(this.operationRepository).save(operation);
    }

    @Test
    void shouldReceiveOperationWithJsonProcessingException() throws JsonProcessingException {
        String operationString = "operationString";

        when(this.objectMapper.readValue(operationString, Operation.class)).thenThrow(JsonProcessingException.class);
        this.receiver.receiveOperation(operationString);
        verifyNoInteractions(this.operationRepository);
    }
}
