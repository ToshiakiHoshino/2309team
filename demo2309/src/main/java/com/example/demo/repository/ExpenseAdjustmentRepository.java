package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ExpenseAdjustmentEntity;

/**
 * 経費情報 Repository
 */
@Repository
public interface ExpenseAdjustmentRepository extends JpaRepository<ExpenseAdjustmentEntity, Integer> {
	
}