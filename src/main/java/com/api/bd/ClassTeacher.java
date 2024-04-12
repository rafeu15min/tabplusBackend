package com.api.bd;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "class_teacher")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClassTeacher {

    @OneToMany(mappedBy = "teacher_class")
    @JoinColumn(name = "teacher_id")
    private int teacher_teacher_id;

    @OneToMany(mappedBy = "teacher_class")
    @JoinColumn(name = "class_id")
    private int class_class_id;
}
