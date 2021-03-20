package com.k7.jdbctemplate.entyties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {
    private String name;
    private ContactType type;
    private String value;
}
