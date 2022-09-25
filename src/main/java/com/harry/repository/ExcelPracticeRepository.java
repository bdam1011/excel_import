package com.harry.repository;

import com.harry.domain.ExcelPractice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcelPracticeRepository extends JpaRepository<ExcelPractice,String> {
}
