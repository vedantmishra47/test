package com.example.test;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Comparator;

@Entity
@Getter
@Setter
@Table(name="Student")
public class Student implements Comparator<Student> {

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

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getId()>o2.getId())
            return 1;
        else if(o1.getId()<o2.getId())
            return -1;
        else
            return 0;
    }


    /*@Override
    public int compareTo(Student o) {
        *//*if(this.getId()>o.getId())
            return 1;
        else if(this.getId()<o.getId())
            return -1;
        else
            return 0;*//*
        return this.getName().compareToIgnoreCase(o.getName());

    }*/
}