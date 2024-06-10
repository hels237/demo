package com.luv2code.demo.serviceImpl;


import com.luv2code.demo.dto.UserDto;
import com.luv2code.demo.exceptions.InvalidOperationException;
import com.luv2code.demo.model.User;
import com.luv2code.demo.repository.UserRepository;
import com.luv2code.demo.service.UserService;
import com.luv2code.demo.validator.ObjectValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private  final ObjectValidator<UserDto> validator;

    @Override
    public Integer save(UserDto userDto) {

        // validate the user
        validator.validate(userDto);

        //save the user
        return userRepository.save(UserDto.toEntity(userDto)).getId();
    }

    @Override
    public UserDto findById(Integer id) {

        return userRepository.findById(id).map(UserDto::fromEntity)
                            .orElseThrow(
                                ()-> new EntityNotFoundException(" User not found whit the provided ID : "+id)
                            );
    }

    @Override
    public Integer delete(Integer id) {

        if(id ==  null){
            throw new InvalidOperationException(" the ID provided is null : "+id," can not DELETED");
        }
        userRepository.deleteById(id);
        return id;
    }


    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserDto::fromEntity).toList();
    }

}
