package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.ExpenseListService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class ExpenseListController {

  /**
   * ユーザー情報 Service
   */
  @Autowired
  private ExpenseListService expenseClaimService;

  /**
   * ユーザー情報詳細画面を表示
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @GetMapping("/expenseList/{id}")
  public String displayView(@PathVariable Long id, Model model) {
    return "expenseList/view";
  }
  

  

}