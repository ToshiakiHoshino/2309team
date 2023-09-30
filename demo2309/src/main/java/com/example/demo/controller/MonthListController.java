package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.MonthListEntity;
import com.example.demo.service.MonthListService;


/**
	 * ユーザー情報 Controller
	 */
	@Controller
	public class MonthListController {
		
	  /**
	   * ユーザー情報 Service
	   */
	  @Autowired
	  private MonthListService monthListService;
	  
	  /**
	   * 月別勤怠一覧画面を表示
	   * @param model Model
	   * @return 月別勤怠一覧画面のHTML
	   */
	  @GetMapping(value = "templates/MonthList")
	  public String displayList(Model model) {
		List<MonthListEntity> monthList = monthListService.searchAll();
	    model.addAttribute("monthList", monthList);
	    return "templates/MonthList";

	  }
	    
}
