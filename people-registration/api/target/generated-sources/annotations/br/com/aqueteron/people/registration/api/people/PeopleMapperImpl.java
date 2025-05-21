package br.com.aqueteron.people.registration.api.people;

import br.com.aqueteron.people.registration.api.model.PeopleApiSchema;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T22:34:26-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Amazon.com Inc.)"
)
@Component
public class PeopleMapperImpl implements PeopleMapper {

    @Override
    public People toPeople(UUID peopleId, PeopleApiSchema peopleApiSchema) {
        if ( peopleId == null && peopleApiSchema == null ) {
            return null;
        }

        UUID id = null;
        id = peopleId;

        People people = new People( id );

        if ( peopleApiSchema != null ) {
            people.setName( peopleApiSchema.getNome() );
            people.setSurname( peopleApiSchema.getSobrenome() );
            people.setAge( peopleApiSchema.getIdade() );
            people.setCountry( peopleApiSchema.getPais() );
        }

        return people;
    }

    @Override
    public PeopleApiSchema toPeopleApiSchema(People people) {
        if ( people == null ) {
            return null;
        }

        PeopleApiSchema peopleApiSchema = new PeopleApiSchema();

        peopleApiSchema.setNome( people.getName() );
        peopleApiSchema.setSobrenome( people.getSurname() );
        peopleApiSchema.setIdade( people.getAge() );
        peopleApiSchema.setPais( people.getCountry() );
        if ( people.getId() != null ) {
            peopleApiSchema.setId( people.getId().toString() );
        }

        return peopleApiSchema;
    }

    @Override
    public List<PeopleApiSchema> toPeopleApiSchemaList(List<People> peopleList) {
        if ( peopleList == null ) {
            return null;
        }

        List<PeopleApiSchema> list = new ArrayList<PeopleApiSchema>( peopleList.size() );
        for ( People people : peopleList ) {
            list.add( toPeopleApiSchema( people ) );
        }

        return list;
    }
}
