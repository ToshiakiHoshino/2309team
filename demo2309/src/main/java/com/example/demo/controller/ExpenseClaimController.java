package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.ExpenseClaimRequest;
import com.example.demo.service.ExpenseClaimService;

/**
 * 経費申請 Controller
 */
@Controller
public class ExpenseClaimController {

	/**
	 * 経費申請 Service
	 */
	@Autowired
	private ExpenseClaimService expenseClaimService;

	/**
	 * 経費申請画面を表示
	 * @param model Model
	 * @return 経費申請画面
	 */
	@GetMapping(value = "/expenseClaim")
	public String displayAdd(Model model) {
		model.addAttribute("expenseClaimRequest", new ExpenseClaimRequest());
		return "expenseClaim";
	}

	/**
	 * 経費申請
	 * @param expenseClaimRequest リクエストデータ
	 * @param model Model
	 * @return 経費申請画面
	 */
	@PostMapping("/expenseClaim/create")
	public String create(@ModelAttribute @Validated ExpenseClaimRequest expenseClaimRequest, BindingResult result, Model model) {

		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "expenseClaim";
		}
		// 経費申請
		expenseClaimService.create(expenseClaimRequest);
		return "redirect:/expenseClaim";
	}

}