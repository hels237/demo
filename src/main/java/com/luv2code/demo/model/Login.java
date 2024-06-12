package com.luv2code.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "login")
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    private Integer id;
    private String username;
    private String password;
}
