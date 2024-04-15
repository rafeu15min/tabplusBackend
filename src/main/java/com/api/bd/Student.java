package com.api.bd;

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

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.api.validator.Password;

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
    private int student_id;
    
    private String student_name;
    
    private String student_username;

    private String student_password;
    
    //fk one-to-many
    private int class_id;

    public void setStudentPassword(String newPassword) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        Password password = new Password();
        this.student_password = password.hash(newPassword);
    }
}