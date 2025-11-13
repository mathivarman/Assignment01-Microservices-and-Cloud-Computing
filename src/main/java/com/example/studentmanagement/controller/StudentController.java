package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student saved = studentService.saveStudent(student);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updated = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }


    @GetMapping("/search/by-name")
    public ResponseEntity<List<Student>> searchByName(@RequestParam String name) {
        List<Student> students = studentService.searchByName(name);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/search/by-course")
    public ResponseEntity<List<Student>> searchByCourse(@RequestParam String course) {
        List<Student> students = studentService.searchByCourse(course);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Student>> getStudentsWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Page<Student> result = studentService.getStudentsWithPaginationAndSorting(page, size, sortBy, direction);
        return ResponseEntity.ok(result);
    }
}
