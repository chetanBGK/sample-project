package com.sample.serviceImpl;

import com.sample.entity.Branch;
import com.sample.service.BranchService;
import com.sample.studentRepo.BranchRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepo branchRepo;

    public BranchServiceImpl(BranchRepo branchRepo) {
        this.branchRepo = branchRepo;
    }

    @Override
    public List<Branch> getAllBranches() {
        return branchRepo.findAll();

    }

    @Override
    public Branch getBranchById(int id) {
        Branch branch = branchRepo.findById(id).orElse(null);
        return branch;
    }

    @Override
    public Branch createBranch(Branch branch) {
        return branchRepo.save(branch);
    }

    @Override
    public Branch updateBranch(int id, Branch branch) {
        Branch existingBranch = branchRepo.findById(id).orElse(null);
        if (existingBranch != null) {
            existingBranch.setBranchname(branch.getBranchname());
            return branchRepo.save(existingBranch);
        }
        return null;
    }

    @Override
    public void deleteBranch(int id) {
        branchRepo.deleteById(id);
    }
}
