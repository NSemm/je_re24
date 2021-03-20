package com.k7.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class Note {
    private String name;
    private String description;
    private Timestamp ctime;


}
