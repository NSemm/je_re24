package com.k7.jdbctemplate.entyties;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String login;
    private LocalDateTime dateBorn;
    private String password;
}
