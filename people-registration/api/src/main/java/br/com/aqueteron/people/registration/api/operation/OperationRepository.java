package br.com.aqueteron.people.registration.api.operation;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OperationRepository extends MongoRepository<Operation, UUID> {
}
