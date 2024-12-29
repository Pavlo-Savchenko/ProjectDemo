package org.example.dto;

import lombok.Data;

@Data
public class PersonDto {
    private String gender;
    private NameDto name;
    private LocationDto location;
    private String nat;
}
