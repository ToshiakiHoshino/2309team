package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ExpenseAdjustmentRequest;
import com.example.demo.entity.ExpenseAdjustmentEntity;
import com.example.demo.repository.ExpenseAdjustmentRepository;

/**
 * 経費情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ExpenseAdjustmentService {

	/**
	 * 経費情報 Repository
	 */
	@Autowired
	private ExpenseAdjustmentRepository expenseAdjustmentRepository;

	/**
	 * 経費情報 主キー検索
	 * @return 検索結果
	 */
	public ExpenseAdjustmentEntity findById(Integer expenseId) {
		return expenseAdjustmentRepository.findById(expenseId).get();
	}

	/**
	 * 経費情報 更新
	 */
	public void update(ExpenseAdjustmentRequest expenseAdjustmentRequest) {
		ExpenseAdjustmentEntity expenseAdjustmentEntity = findById(expenseAdjustmentRequest.getExpenseId());
		expenseAdjustmentEntity.setExpenseId(expenseAdjustmentRequest.getExpenseId());
		expenseAdjustmentEntity.setApplicationDate(expenseAdjustmentRequest.getApplicationDate());
		expenseAdjustmentEntity.setItem(expenseAdjustmentRequest.getItem());
		expenseAdjustmentEntity.setPrice(expenseAdjustmentRequest.getPrice());
		expenseAdjustmentEntity.setRemarks(expenseAdjustmentRequest.getRemarks());
		expenseAdjustmentRepository.save(expenseAdjustmentEntity);
	}
}