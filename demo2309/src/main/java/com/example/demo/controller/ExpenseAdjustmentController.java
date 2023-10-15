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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ExpenseAdjustmentRequest;
import com.example.demo.entity.ExpenseAdjustmentEntity;
import com.example.demo.service.ExpenseAdjustmentService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class ExpenseAdjustmentController {
  /**
   * 経費情報 Service
   */
  @Autowired
  private ExpenseAdjustmentService expenseAdjustmentService;

  /**
   * 経費修正画面を表示
   * @param id 表示する経費ID
   * @param model Model
   * @return 経費編集画面
   */
  @GetMapping("/user/{expenseId}/expenseadjustment")
  public String displayEdit(@PathVariable Integer expenseId, Model model) {
	ExpenseAdjustmentEntity user = expenseAdjustmentService.findById(expenseId);
    ExpenseAdjustmentRequest expenseAdjustmentRequest = new ExpenseAdjustmentRequest();
    expenseAdjustmentRequest.setExpenseId(user.getExpenseId());
    expenseAdjustmentRequest.setApplicationDate(user.getApplicationDate());
    expenseAdjustmentRequest.setItem(user.getItem());
    expenseAdjustmentRequest.setPrice(user.getPrice());
    expenseAdjustmentRequest.setRemarks(user.getRemarks());
    model.addAttribute("expenseAdjustmentRequest", expenseAdjustmentRequest);
    return "expenseadjustment";
  }
  
  /**
   * 経費更新
   * @param ExpenseAdjustmentRequest リクエストデータ
   * @param model Model
   * @return 経費編集画面
   */
  @RequestMapping("/user/expenseadjustment/ceate")
  public String expenseadjustment(@Validated @ModelAttribute ExpenseAdjustmentRequest expenseAdjustmentRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "expenseadjustment";
    }
    
    // 経費情報の更新
    expenseAdjustmentService.update(expenseAdjustmentRequest);
    return "mypage";
  }
}
