package com.example.codoceanbmongo.submitcode.parameter.service;

import com.example.codoceanbmongo.submitcode.parameter.entity.Parameter;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParameterServiceImpl implements ParameterService{

    @Override
    public StringBuilder createListParameter(List<Parameter> listParameters) {

        List<String> parameters = listParameters.stream()
                .sorted(Comparator.comparingInt(Parameter::getIndex))
                .map(p -> p.getInputDataType() +" "+ p.getName())
                .collect(Collectors.toList());

        return new StringBuilder(String.join(", ", parameters));
    }
}
