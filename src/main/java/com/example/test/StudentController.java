package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/v1/student/{id}")
    public ResponseEntity<Object> fetchData(@PathVariable int id){
        Student student=studentService.fetchData(id);
        if(student !=null)
            return new ResponseEntity<Object>(student, HttpStatus.OK);
        else
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/v1/student")
    public ResponseEntity<Object> fetchAll(){
        List<Student> studentList=studentService.fetchAllData();
        if(studentList !=null)
            return new ResponseEntity<Object>(studentList,HttpStatus.OK);
        else
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/v1/student")
    public ResponseEntity<Object> addData(@RequestBody Student student){
        boolean result=studentService.addData(student);
        if(result)
            return new ResponseEntity<Object>(HttpStatus.CREATED);
        else
            return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping("/v1/student/{id}")
    public ResponseEntity<Object> deleteData(@PathVariable int id){
        boolean result=studentService.deleteData(id);
        if(result)
            return new ResponseEntity<Object>(HttpStatus.OK);
        else
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/v1/student/{id}")
    public ResponseEntity<Object> updateData(@PathVariable int id,@RequestBody Student student){
        boolean result=studentService.updateData(id,student);
        if(result)
            return new ResponseEntity<Object>(HttpStatus.CREATED);
        else
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }
}