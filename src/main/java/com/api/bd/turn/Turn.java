package com.api.bd.turn;

import java.util.Set;

import com.api.bd.operation.Operation;
import com.api.bd.student.Student;

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

@Entity
@Table(name = "turn")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long turn_id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student getStudent;

    private String created_at;

    @OneToMany(targetEntity = Operation.class, cascade = CascadeType.ALL, mappedBy = "turn")
    @JoinColumn(name = "turn_id")
    private Set<Operation> getOperations;
}
