package com.example.PracticeSBProject.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Integer id;
    private String name;
    private Integer roll_number;
    private String which_class;
    private String section;

}
