package com.luv2code.demo.validator;

import com.luv2code.demo.exceptions.ObjectValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();


    public void validate(T object){

        Set<ConstraintViolation<T>> violations = validator.validate(object);

        if(!violations.isEmpty()){

            Set<String> errorMessage = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());

            //todo throw an exception
            throw  new ObjectValidationException(errorMessage,object.getClass().getName());
        }
    }
}
