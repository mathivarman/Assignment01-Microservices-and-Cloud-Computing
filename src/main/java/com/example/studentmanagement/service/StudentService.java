package com.example.studentmanagement.service;

import com.example.studentmanagement.exception.StudentNotFoundException;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // 🔹 Create Student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // 🔹 Get All Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // 🔹 Get Student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    // 🔹 Update Student
    public Student updateStudent(Long id, Student updated) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));

        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setCourse(updated.getCourse());
        existing.setAge(updated.getAge());

        return studentRepository.save(existing);
    }

    // 🔹 Delete Student
    public void deleteStudent(Long id) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        studentRepository.delete(existing);
    }

    // 🔹 Search by Name
    public List<Student> searchByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    // 🔹 Search by Course
    public List<Student> searchByCourse(String course) {
        return studentRepository.findByCourseContainingIgnoreCase(course);
    }

    // 🔹 Pagination + Sorting
    public Page<Student> getStudentsWithPaginationAndSorting(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return studentRepository.findAll(pageable);
    }
}
