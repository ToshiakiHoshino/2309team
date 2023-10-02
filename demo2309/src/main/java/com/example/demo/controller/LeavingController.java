//package com.example.demo.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.ObjectError;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.example.demo.dto.LeavingRequest;
//import com.example.demo.service.LeavingService;
//
//@Controller
//public class LeavingController {
//
//	//Service
//	@Autowired
//	private LeavingService leavingService;
//
//	
//	//新規登録画面の表示
//		@GetMapping("/user/leaving")
//		public String displayAdd(Model model) {
//			model.addAttribute("leavingRequest", new LeavingRequest());
//
//			return "user/leaving";
//		}
//		
//		
//	//退勤登録
//	@RequestMapping("/user/create")
//	public String create(@Validated @ModelAttribute LeavingRequest leavingRequest, BindingResult result,
//			Model model) {
//		//入力判定
//		if (result.hasErrors()) {
//			// 入力チェックエラー
//			List<String> errorList = new ArrayList<String>();
//			for (ObjectError error : result.getAllErrors()) {
//				errorList.add(error.getDefaultMessage());
//			}
//			//エラー判定後の画面遷移
//			model.addAttribute("validationError", errorList);
//			model.addAttribute("leavingRequest", leavingRequest);
//			return "user/leaving";
//		}
//		// 退勤情報の登録
//		leavingService.create(leavingRequest);
//		return "redirect:/user/attendance_list";
//	}
//}