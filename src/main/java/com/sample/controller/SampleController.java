package com.sample.controller;

import com.sample.entity.Branch;
import com.sample.entity.Students;
import com.sample.service.StudentService;
import com.sample.studentRepo.BranchRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SampleController {

    private final BranchRepo branchRepo;

    @Autowired
    StudentService studentService;

    public SampleController(BranchRepo branchRepo) {
        this.branchRepo = branchRepo;
    }

    @GetMapping("welcome")
    public String getMessage()
    {
        return "Welocme to first application";
    }

    @PostMapping("createstudent/{branchid}")
    public Students createStudent
            (@Valid @RequestBody Students students, @PathVariable int branchid)
    {
        Branch branch=branchRepo.findById(branchid).get();
        students.setBranch(branch);
       return studentService.createStudent(students,branchid);
    }

    @GetMapping("getallstudents")
    public List<Students> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("getstudent/{rollno}")
    public Students getStudentById(@PathVariable int rollno)
        {
        return studentService.getStudentById(rollno);
    }

    @PutMapping("updatestudent/{rollno}")
    public Students updateStudent(@RequestBody Students student,@PathVariable int rollno)
        {
        return studentService.updateStudent(student,rollno);
    }

    @DeleteMapping("deletestudent/{rollno}")
    public void deleteStudent(@PathVariable int rollno)
        {
        studentService.deleteStudent(rollno);
    }

}
