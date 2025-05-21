package br.com.aqueteron.people.registration.api.people;

import br.com.aqueteron.people.registration.api.model.PeopleApiSchema;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface PeopleMapper {

    @Mapping(source = "peopleId", target = "id")
    @Mapping(source = "peopleApiSchema.nome", target = "name")
    @Mapping(source = "peopleApiSchema.sobrenome", target = "surname")
    @Mapping(source = "peopleApiSchema.idade", target = "age")
    @Mapping(source = "peopleApiSchema.pais", target = "country")
    People toPeople(UUID peopleId, PeopleApiSchema peopleApiSchema);

    @Mapping(source = "name", target = "nome")
    @Mapping(source = "surname", target = "sobrenome")
    @Mapping(source = "age", target = "idade")
    @Mapping(source = "country", target = "pais")
    PeopleApiSchema toPeopleApiSchema(People people);

    List<PeopleApiSchema> toPeopleApiSchemaList(List<People> peopleList);

}
