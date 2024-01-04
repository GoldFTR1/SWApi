package dev.peter.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import dev.peter.demo.model.Person;
import dev.peter.demo.web.dto.CreatePersonRequest;
import dev.peter.demo.web.dto.UpdatePersonRequest;

@Mapper
public abstract class PersonMapper {
    

    @Mapping(target="id", ignore = true)
    @Mapping(target = "firstname", source= "firstName", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "lastname", source="lastName", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "gender", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target= "films", source="films", ignore=true)

     public abstract Person personFromCreateRequest(CreatePersonRequest req);


    public abstract void updatePersonFromUpdateRequest(UpdatePersonRequest req, @MappingTarget Person person);
}
