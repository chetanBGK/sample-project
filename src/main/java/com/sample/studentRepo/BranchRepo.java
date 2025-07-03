package com.sample.studentRepo;

import com.sample.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<Branch, Integer> {
}
