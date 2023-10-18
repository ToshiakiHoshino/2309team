package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.ExpenseListEntity;
import com.example.demo.service.ExpenseListService;

/**
 * 経費一覧 Controller
 */
@Controller
public class ExpenseListController {

	/**
	 * 経費一覧 Service
	 */
	@Autowired
	private ExpenseListService expenseClaimService;

	/**
	 * 経費一覧画面を表示
	 * @param model Model
	 * @return 経費一覧画面
	 */
	@GetMapping(value = "/expenseList/{user_id}")
	public String displayList(Model model) {
		List<ExpenseListEntity> expenseList = expenseClaimService.searchAll();
		model.addAttribute("expenseList", expenseList);
		return "expenseList";
	}
}