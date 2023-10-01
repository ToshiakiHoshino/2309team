package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  public User findById(Long id) {
    return ExpenseAdjustmentRepository.findById(id).get();
  }
  /**
   * ユーザー情報 更新
   * @param user ユーザー情報
   */
  public void update(ExpenseAdjustmentRequest expenseAdjustmentRequest) {
    User user = findById(expenseAdjustmentRequest.getId());
    user.setAddress(expenseAdjustmentRequest.getAddress());
    user.setName(expenseAdjustmentRequest.getName());
    user.setPhone(expenseAdjustmentRequest.getPhone());
    user.setUpdateDate(new Date());
    ExpenseAdjustmentRepository.save(user);
  }
}