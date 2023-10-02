package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ExpenseAdjustmentRequest;
import com.example.demo.entity.ExpenseAdjustmentEntity;
import com.example.demo.repository.ExpenseAdjustmentRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ExpenseAdjustmentService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private ExpenseAdjustmentRepository expenseAdjustmentRepository;
  
  /**
   * ユーザー情報 主キー検索
   * @return 検索結果
   */
  public ExpenseAdjustmentEntity findById(Long id) {
    return expenseAdjustmentRepository.findById(id).get();
  }
  /**
   * ユーザー情報 更新
   * @param user ユーザー情報
   */
  public void update(ExpenseAdjustmentRequest expenseAdjustmentRequest) {
	ExpenseAdjustmentEntity expenseAdjustmentEntity = findById(expenseAdjustmentRequest.getExpensesId());
	expenseAdjustmentEntity.setExpensesId(expenseAdjustmentRequest.getExpensesId());
	expenseAdjustmentEntity.setUserId(expenseAdjustmentRequest.getUserId());
	expenseAdjustmentEntity.setApplicationDate(expenseAdjustmentRequest.getApplicationDate());
	expenseAdjustmentEntity.setItem(expenseAdjustmentRequest.getItem());
	expenseAdjustmentEntity.setPrice(expenseAdjustmentRequest.getPrice());
	expenseAdjustmentEntity.setRemarks(expenseAdjustmentRequest.getRemarks());
    expenseAdjustmentRepository.save(expenseAdjustmentEntity);
  }
}