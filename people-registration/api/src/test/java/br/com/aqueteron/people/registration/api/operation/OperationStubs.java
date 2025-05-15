package br.com.aqueteron.people.registration.api.operation;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class OperationStubs {

    public static Operation createNewOperation() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return new Operation(
                UUID.randomUUID(),
                localDateTime.minusSeconds(5),
                localDateTime,
                HttpMethod.POST.name(),
                "",
                HttpStatus.OK.value()
        );
    }

}
