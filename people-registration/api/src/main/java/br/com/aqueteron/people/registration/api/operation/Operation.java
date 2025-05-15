package br.com.aqueteron.people.registration.api.operation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collation = "operations")
public record Operation(
        @Id
        UUID id,

        LocalDateTime initialDateTime,

        LocalDateTime finalDateTime,

        String requestMethod,

        String requestPath,

        Integer responseStatus
) {
}
