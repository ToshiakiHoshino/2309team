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
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.LeavingRequest;
import com.example.demo.service.LeavingService;

@Controller
public class LeavingController {

	//Service
	@Autowired
	private LeavingService leavingService;

	//登録画面の表示
	@GetMapping("/user/leaving/{attendance_id}")
	public String displayAdd(Model model,@ModelAttribute LeavingRequest leavingRequest,@PathVariable("attendance_id") Integer attendance_id) {
		leavingService.findById(attendance_id);
		//			model.addAttribute("leavingRequest", new LeavingRequest());
		//			model.addAttribute("leavingRequest", leavingRequest);
		return "leaving";
	}

	//退勤登録（更新）
	@PostMapping("/user/leaving/create")
	public String update(@ModelAttribute("leavingRequest") @Validated  LeavingRequest leavingRequest, BindingResult result,
			Model model) {
		//入力判定
		if (result.hasErrors()) {
			// 入力チェックエラー
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			//エラー判定後の画面遷移
			model.addAttribute("validationError", errorList);
			model.addAttribute("leavingRequest", leavingRequest);

			return "leaving";
		}
		// 退勤情報の登録
		leavingService.update(leavingRequest);
		return String.format("redirect:/user/attendance_list", leavingRequest.getUser_id());
	}



}