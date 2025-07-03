package com.sample.service;

import com.sample.entity.Branch;

import java.util.List;

public interface BranchService {
    public List<Branch> getAllBranches();
    public Branch getBranchById(int id);
    public Branch createBranch(Branch branch);
    public Branch updateBranch(int id, Branch branch);
    public void deleteBranch(int id);
}
