package com.example.test;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    @SequenceGenerator(name="student_generator", sequenceName = "student_seq" ,allocationSize=1,initialValue=1)
    private int id;

    private String name;

    private String designation;

    public Student() {
    }

    public Student(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }
}