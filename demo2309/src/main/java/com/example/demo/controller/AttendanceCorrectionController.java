package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.AttendanceCorrectionRequest;
import com.example.demo.entity.AttendanceCorrectionEntity;
import com.example.demo.service.AttendanceCorrectionService;

import ch.qos.logback.core.model.Model;

@Controller
public class AttendanceCorrectionController{
	
	@Autowired
	AttendanceCorrectionService attendanceCorrectionService;
	
	@GetMapping("/user/{userid}/attendance_correction")
	public String displayEdit(@PathVariable Integer userid, Model model) {
		AttendanceCorrectionEntity user = attendanceCorrectionService.findById(userid);
		AttendanceCorrectionRequest attendanceCorrectionRequest = new AttendanceCorrectionRequest();
		attendanceCorrectionRequest.setStatus(user.getStatu());
		attendanceCorrectionRequest.setStartDate(user.getStartData());
		attendanceCorrectionRequest.setStarTime(user.getStartTime());
		attendanceCorrectionRequest.setEndDate(user.getEndDate());
		attendanceCorrectionRequest.setEndTime(user.getEndTime());
		attendanceCorrectionRequest.setWorkingTime(user.getWorkingTime());
		attendanceCorrectionRequest.setBreakTime(user.getBreakTime());
		attendanceCorrectionRequest.setReasons(user.getReason());
		attendanceCorrectionRequest.setReasons(user.getReason());
		attendanceCorrectionRequest.setRemarks(user.getReason());
		model.addAtribute("attendanceCorrectionRequest", attendanceCorrectionRequest);
		return "user/attendance_correction";
		
	}
	
	@RequestMapping("/user/attendance_correction")
	public String Correction(@Validated @ModelAttribute AttendanceCorrectionRequest attendanceCorrectionRequest, BindingResult result, Model model) {
		attendanceCorrectionService.update(attendanceCorrectionRequest);
		return String.format("redilect:/user/%d", attendanceCorrectionRequest.getId());
	}

}
