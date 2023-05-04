package com.mongodb.rest.api.mapper;

import com.mongodb.rest.api.dto.PersonDto;
import com.mongodb.rest.api.entity.Person;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class Assembler {

    public ModelMapper modelMapper;

    @Inject
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public <S, T> T mapObject (S source, Class<T> targetClass){
        return modelMapper.map(source,targetClass);
    }


}
