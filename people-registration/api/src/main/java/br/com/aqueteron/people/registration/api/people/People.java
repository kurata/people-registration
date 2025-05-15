package br.com.aqueteron.people.registration.api.people;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@RequiredArgsConstructor
@Data
@Entity
public class People implements Serializable {

    @Id
    private final UUID id;

    private String nome;

    private String sobrenome;

    private Integer idade;

    private String pais;

    protected People() {
        this(null);
    }

}
