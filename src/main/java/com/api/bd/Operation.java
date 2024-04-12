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
@Table(name = "operation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int operation_id;

    private int first_term;

    private int second_term;

    private int answer;

    private int is_correct_answer;

    @OneToMany(mappedBy = "operation")
    @JoinColumn(name = "turn_id")
    private int turn_id;
}