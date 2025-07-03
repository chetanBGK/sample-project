package com.sample.controller;

import com.sample.entity.Branch;
import com.sample.service.BranchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("branch")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping("create")
    public Branch createBranch(@RequestBody Branch branch) {
        return branchService.createBranch(branch);
    }

    @GetMapping("getall")
    public List<Branch> getAllBranches() {
        return branchService.getAllBranches();
    }

    @GetMapping("getbyid/{id}")
    public Branch getBranchById(@PathVariable int id) {
        return branchService.getBranchById(id);
    }

    @PutMapping("update/{id}")
    public Branch updateBranch(@PathVariable int id, @RequestBody Branch branch) {
        return branchService.updateBranch(id, branch);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBranch(@PathVariable int id) {
        branchService.deleteBranch(id);
    }
}
