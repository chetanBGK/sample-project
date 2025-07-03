package com.sample.serviceImpl;

import com.sample.entity.Students;

import com.sample.exceptions.ResourceNotFoundException;
import com.sample.service.StudentService;
import com.sample.studentRepo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Students createStudent(Students student,int branchid) {
        return studentRepo.save(student);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Students getStudentById(int rollno) {
        Students students=studentRepo.findById(rollno)
                .orElseThrow(()->new ResourceNotFoundException(rollno));
        return students;
    }

    @Override
    public Students updateStudent(Students student, int rollno) {
        Students students=studentRepo.findById(rollno)
                        .orElseThrow(()->new ResourceNotFoundException(rollno));


        students.setName(student.getName());
        students.setBranch(student.getBranch());
        studentRepo.save(students);
        return students;
    }

    @Override
    public void deleteStudent(int rollno) {
        studentRepo.deleteById(rollno);
    }
}
