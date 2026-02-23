package com.example.PracticeSBProject.dto;

import com.example.PracticeSBProject.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentClassEntity {

    private String which_class;
    private Long count;
}
