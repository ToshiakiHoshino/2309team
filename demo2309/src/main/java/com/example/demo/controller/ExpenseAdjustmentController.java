package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.ExpenseAdjustmentRequest;
import com.example.demo.entity.ExpenseAdjustmentEntity;
import com.example.demo.service.ExpenseAdjustmentService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class ExpenseAdjustmentController {
  /**
   * ユーザー情報 Service
   */
  @Autowired
  private ExpenseAdjustmentService expenseAdjustmentService;

  /**
   * 経費修正画面を表示
   * @param id 表示する経費ID
   * @param model Model
   * @return ユーザー編集画面
   */
  @GetMapping("/user/{id}/edit")
  public String displayEdit(@PathVariable Long id, Model model) {
	ExpenseAdjustmentEntity user = expenseAdjustmentService.findById(id);
    ExpenseAdjustmentRequest expenseAdjustmentRequest = new ExpenseAdjustmentRequest();
    expenseAdjustmentRequest.setExpensesId(user.getExpensesId());
    expenseAdjustmentRequest.setUserId(user.getUserId());
    expenseAdjustmentRequest.setApplicationDate(user.getApplicationDate());
    expenseAdjustmentRequest.setItem(user.getItem());
    expenseAdjustmentRequest.setPrice(user.getPrice());
    expenseAdjustmentRequest.setRemarks(user.getRemarks());
    model.addAttribute("expenseAdjustmentRequest", expenseAdjustmentRequest);
    return "user/edit";
  }
  
  /**
   * ユーザー更新
   * @param ExpenseAdjustmentRequest リクエストデータ
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @RequestMapping(value = "/user/update", method = RequestMethod.POST)
  public String update(@Validated @ModelAttribute ExpenseAdjustmentRequest expenseAdjustmentRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      ArrayList<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "user/edit";
    }
    // ユーザー情報の更新
    expenseAdjustmentService.update(expenseAdjustmentRequest);
    return String.format("redirect:/user/%d", expenseAdjustmentRequest.getExpensesId());
  }
}
