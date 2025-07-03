package com.sample.studentRepo;

import com.sample.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students,Integer> {
}
