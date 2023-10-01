package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ユーザー情報 Repository
 */
@Repository
public interface ExpenseAdjustmentRepository extends JpaRepository<User, Long> {
	
}
