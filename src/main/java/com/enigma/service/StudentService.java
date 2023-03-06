package com.enigma.service;

import com.enigma.model.Major;
import com.enigma.model.Student;
import com.enigma.model.UserCredential;
import com.enigma.repository.MajorRepo;
import com.enigma.repository.StudentRepo;

import java.util.List;

public class StudentService implements IService<Student> {
    private StudentRepo studentRepo;
    private MajorService majorService;

    public StudentService(StudentRepo studentRepo, MajorService majorService) {
        this.studentRepo = studentRepo;
        this.majorService = majorService;
    }

    public void insert(Student student, UserCredential userCredential, String majorId) {
        System.out.println(student);
        Major major = majorService.getById(majorId);
        student.setUserCredential(userCredential);
        student.setMajor(major);
        userCredential.setStudent(student);

        studentRepo.create(student);
    }

    @Override
    public void insert(Student params) {

    }

    @Override
    public void delete(String id) {
        studentRepo.delete(id);
    }

    @Override
    public void update(Student student) {
        studentRepo.update(student);
    }

    @Override
    public Student getById(String id) {
        Student student = studentRepo.findOne(id);
        return student;
    }

    @Override
    public void getAll(Integer page, Integer size) {
        List<Student> students = studentRepo.findAll(page, size);
        students.forEach(System.out::println);
    }

    @Override
    public void getAllByName(String name) {
        List<Student> students = studentRepo.findByName(name);
        students.forEach(System.out::println);
    }
}
