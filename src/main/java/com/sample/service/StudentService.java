package com.sample.service;

import com.sample.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentService{

    public Students createStudent(Students student,int branchid);
    public List<Students> getAllStudents();

    public Students getStudentById(int rollno);
    public Students updateStudent(Students student,int rollno);
    public void deleteStudent(int rollno);
}
