package com.api.bd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "class")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    // `student_id` integer UNIQUE PRIMARY KEY,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;
    // `student_name`varchar(255),
    private String student_name;
    // `student_alias` varchar(255),
    private String student_alias;
    // `class_id` integer (foreign key)
    @OneToMany(mappedBy = "student")
    @JoinColumn(name = "class_id")
    private int class_id;
}
