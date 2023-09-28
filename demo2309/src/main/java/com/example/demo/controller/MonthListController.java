package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.MonthListService;

import ch.qos.logback.core.model.Model;

/**
	 * ユーザー情報 Controller
	 */
	@Controller
	public class MonthListController {
		
	  /**
	   * ユーザー情報 Service
	   */
	  @Autowired
	  MonthListService MonthListService;
	  
	  /**
	   * 月別勤怠一覧画面を表示
	   * @param model Model
	   * @return 月別勤怠一覧画面のHTML
	   */
	  @RequestMapping(value = "/user/month_List", method = RequestMethod.GET)
	  public String MonthList(Model model) {
		userlist<User> userlist = MonthListService.searchAll();
	    model.addAttribute("month_List", month_List);
	    return "user/month_List";

	  }
	    
}
