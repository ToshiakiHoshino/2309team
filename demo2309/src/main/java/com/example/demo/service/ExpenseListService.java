package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ExpenseListEntity;
import com.example.demo.repository.ExpenseListRepository;

/**
 * 経費一覧 Service
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class ExpenseListService {
	
	/**
	 * 経費一覧 Repository
	 */
	@Autowired
	private ExpenseListRepository expenseListRepository;

	/**
	 * 経費一覧 全検索
	 * @return 検索結果
	 */
	public List<ExpenseListEntity> searchAll() {
		return expenseListRepository.findAll();
	}
}