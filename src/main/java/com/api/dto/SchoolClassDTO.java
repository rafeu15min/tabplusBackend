package com.api.dto;

import lombok.Getter;
import lombok.Setter;
import com.api.models.Student;
import java.util.*;

@Getter
@Setter
public class SchoolClassDTO {
    private Long school_class_id;
    private String school_class_grade;
    private int school_class_year;
    private List<Student> getStudents;
}
