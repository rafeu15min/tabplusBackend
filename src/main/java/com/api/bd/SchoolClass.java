package com.api.bd;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "school_class")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int school_class_id;

    private String school_class_grade;

    private int school_class_year;

    
    @ManyToMany
    @JoinTable(
        name = "class_teacher",
        joinColumns = @JoinColumn(name = "school_class_id"),
        inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    Set<Teacher> teachers;
}
