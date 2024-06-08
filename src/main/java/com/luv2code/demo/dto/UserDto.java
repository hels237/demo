package com.luv2code.demo.dto;


import com.luv2code.demo.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Integer id;

    private String firstname;

    private String lastname;

    private String email;


    /*--------------------------- mapping -----------------------------------*/

    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
    }

    public static User toEntity(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .build();
    }

}
