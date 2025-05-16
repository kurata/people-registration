package br.com.aqueteron.people.registration.api.people;

import br.com.aqueteron.people.registration.api.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public People createPeople(final People people) {
        return this.peopleRepository.save(people);
    }

    public People retrievePeople(final UUID peopleId) {
        return this.peopleRepository
                .findById(peopleId)
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "Registro não encontrado"));
    }

    public List<People> searchPeople() {
        return this.peopleRepository.findAll();
    }

    public People editPeople(final People people) {
        People persistedPeople = this.peopleRepository
                .findById(people.getId())
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "Registro não encontrado"));
        if (people.getNome() != null) {
            persistedPeople.setNome(people.getNome());
        }
        if (people.getSobrenome() != null) {
            persistedPeople.setSobrenome(people.getSobrenome());
        }
        if (people.getIdade() != null) {
            persistedPeople.setIdade(people.getIdade());
        }
        if (people.getPais() != null) {
            persistedPeople.setPais(people.getPais());
        }
        return persistedPeople;
    }
}
