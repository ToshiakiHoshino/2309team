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

import com.example.demo.dto.AttendanceCorrectionRequest;
import com.example.demo.entity.AttendanceCorrectionEntity;
import com.example.demo.service.AttendanceCorrectionService;




@Controller
public class AttendanceCorrectionController{
	
	@Autowired
	AttendanceCorrectionService attendanceCorrectionService;
	
	@GetMapping("/user/{attendaneId}/attendance_correction")
	public String displayEdit(@PathVariable Long attendanceId, Model model) {
		AttendanceCorrectionEntity user = attendanceCorrectionService.findById(attendanceId);
		AttendanceCorrectionRequest attendanceCorrectionRequest = new AttendanceCorrectionRequest();
		attendanceCorrectionRequest.setUserId(user.getUserId());
		attendanceCorrectionRequest.setStatus(user.getStatus());
		attendanceCorrectionRequest.setStartDate(user.getStartData());
		attendanceCorrectionRequest.setStarTime(user.getStartTime());
		attendanceCorrectionRequest.setEndDate(user.getEndDate());
		attendanceCorrectionRequest.setEndTime(user.getEndTime());
		attendanceCorrectionRequest.setBreakTime(user.getBreakTime());
		attendanceCorrectionRequest.setReasons(user.getReason());
		attendanceCorrectionRequest.setRemarks(user.getRemarks());
		model.addAttribute("attendanceCorrectionRequest", attendanceCorrectionRequest);
		return "attendance_correction";
		
	}
	
	@RequestMapping("/user/attendance_correction")
	public String Correction(@Validated @ModelAttribute AttendanceCorrectionRequest attendanceCorrectionRequest, BindingResult result, Model model) {
		if(result.hasErrors()) {
		 ArrayList<String> errorList = new ArrayList<String>();
		 
		 for(ObjectError error : result.getAllErrors()) {
		 errorList.add(error.getDefaultMessage());
			}
		model.addAttribute("validationError", errorList);
		return "attendance_correction";
		}
		
		attendanceCorrectionService.update(attendanceCorrectionRequest);
		return String.format("redilect:/user/%d", attendanceCorrectionRequest.getUserId());
	}

}
