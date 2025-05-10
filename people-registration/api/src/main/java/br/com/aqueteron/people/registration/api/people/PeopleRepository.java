package br.com.aqueteron.people.registration.api.people;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PeopleRepository extends JpaRepository<People, UUID> {
}
