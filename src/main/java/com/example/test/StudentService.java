package com.example.test;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student fetchData(int id){
        Optional<Student> students= Optional.ofNullable(studentRepository.findById(id)).orElse(null);
        if(students.isPresent())
            return students.get();
        else
            return null;
    }
    public List<Student> fetchAllData(){
        List<Student> studentList=Optional.ofNullable(studentRepository.findAll()).orElse(null);
        if(!studentList.isEmpty()) {
            Collections.sort(studentList);
            return studentList;
        }
        else
            return null;
    }
    public boolean addData(Student student){
        String designation=student.getDesignation();
        String name=student.getName();

        if(!StringUtils.isBlank(designation) && !StringUtils.isBlank(name)) {
            Student student1 = studentRepository.findByDesignationAndName(designation, name);
            if (student1 == null) {
                try {
                    studentRepository.save(student);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } else
                return false;
        }
        else
            return false;
    }
    public boolean deleteData(int id){
        Optional<Student> student=Optional.ofNullable(studentRepository.findById(id)).orElse(null);
        if(student.isPresent()) {
            try {
                studentRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        else{
            return false;
        }
    }
    public boolean updateData(int id,Student student){
        Optional<Student> students=Optional.ofNullable(studentRepository.findById(id)).orElse(null);
        if(students.isPresent()) {
            students.get().setDesignation(student.getDesignation());
            students.get().setName(student.getName());
        }
        else
            return false;
        try {
            studentRepository.save(students.get());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}