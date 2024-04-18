package com.api.bd.teacher;

import java.util.Set;

import com.api.bd.schoolClass.SchoolClass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO {
    
    private String teacher_name;
    private String teacher_password;
    private String teacher_email;
    private Set<SchoolClass> getSchoolClasses;
}
