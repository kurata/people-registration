package br.com.aqueteron.people.registration.api.people;

import br.com.aqueteron.people.registration.api.model.PeopleApiSchema;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-10T18:37:53-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
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
            people.setNome( peopleApiSchema.getNome() );
            people.setSobrenome( peopleApiSchema.getSobrenome() );
            people.setIdade( peopleApiSchema.getIdade() );
            people.setPais( peopleApiSchema.getPais() );
        }

        return people;
    }

    @Override
    public PeopleApiSchema toPeopleApiSchema(People people) {
        if ( people == null ) {
            return null;
        }

        PeopleApiSchema peopleApiSchema = new PeopleApiSchema();

        if ( people.getId() != null ) {
            peopleApiSchema.setId( people.getId().toString() );
        }
        peopleApiSchema.setNome( people.getNome() );
        peopleApiSchema.setSobrenome( people.getSobrenome() );
        peopleApiSchema.setIdade( people.getIdade() );
        peopleApiSchema.setPais( people.getPais() );

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
