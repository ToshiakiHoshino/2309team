package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.AttendanceListEntity;
import com.example.demo.service.AttendanceListService;

@Controller
public class AttendanceListController {
	@Autowired
    AttendanceListService attendanceListService;
	
//勤怠一覧を表示
	@GetMapping("/user/attendance_list")
	public String displayList(Model model) {
		List<AttendanceListEntity> userlist = attendanceListService.searchAll();
		model.addAttribute("userlist", userlist);
		return "user/attendance_list";
				
	}
}
