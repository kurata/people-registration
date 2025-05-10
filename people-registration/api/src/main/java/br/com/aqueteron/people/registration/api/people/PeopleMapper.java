package br.com.aqueteron.people.registration.api.people;

import br.com.aqueteron.people.registration.api.model.PeopleApiSchema;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface PeopleMapper {

    @Mapping(source = "peopleId", target = "id")
    People toPeople(UUID peopleId, PeopleApiSchema peopleApiSchema);

    PeopleApiSchema toPeopleApiSchema(People people);

    List<PeopleApiSchema> toPeopleApiSchemaList(List<People> peopleList);
}
