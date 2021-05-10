package com.example.springwithreact.student;


import com.example.springwithreact.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
        //throw new ApiRequestException("Oops cannot get all students with custom exception");
    }

    @GetMapping(path = "{studentId}/courses")
    public List<StudentCourse> getAllCoursesForStudent(@PathVariable("studentId") UUID studentId) {
        return studentService.getAllCoursesForStudent(studentId);
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }
}