package com.api.student;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
import com.api.schoolClass.SchoolClass;
import com.api.turn.Turn;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
    
    private String student_name;
    
    private String student_username;

    private String student_password;
    
    @ManyToOne
    @JoinColumn(name = "school_class_id", nullable = false)
    private SchoolClass getSchoolClass;

    @OneToMany(targetEntity = Turn.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Set<Turn> getTurns;
}