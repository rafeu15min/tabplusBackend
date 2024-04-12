package com.api.bd;

import org.hibernate.annotations.TimeZoneColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "turn")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int turn_id;

    @OneToOne(mappedBy = "turn")
    @JoinColumn(name = "student_id")
    private int student_id;

    @TimeZoneColumn
    private String created_at;
}
