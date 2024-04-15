package com.api.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "operation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Operation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int operation_id;

    private int first_term;

    private int second_term;

    private int answer;

    @Column(
        name = "is_correct_answer",
        columnDefinition = "INT(1)"
        )
    private boolean is_correct_answer;

    //fk one-to-many
    private int turn_id;
}