package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ExpenseClaimRequest;
import com.example.demo.entity.ExpenseClaimEntity;
import com.example.demo.repository.ExpenseClaimRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ExpenseClaimService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private ExpenseClaimRepository expenseClaimRepository;

  /**
   * 
   * @param user ユーザー情報
   */
  public void create(ExpenseClaimRequest expenseClaimRequest) {
    Date now = new Date();
    ExpenseClaimEntity expenseClaim = new ExpenseClaimEntity();
    expenseClaim.setUser_id(expenseClaimRequest.getUser_id());
    expenseClaim.setItem(expenseClaimRequest.getItem());
    expenseClaim.setPrice(expenseClaimRequest.getPrice());
    expenseClaim.setRemarks(expenseClaimRequest.getRemarks());
    expenseClaim.setApplication_date(expenseClaimRequest.getApplication_date());
    expenseClaimRepository.save(expenseClaim);
  }
}