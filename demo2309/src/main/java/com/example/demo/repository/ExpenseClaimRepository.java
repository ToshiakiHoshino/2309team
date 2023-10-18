package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ExpenseClaimEntity;

/**
 * 経費申請 Repository
 */
@Repository
public interface ExpenseClaimRepository extends JpaRepository<ExpenseClaimEntity, Long> {}