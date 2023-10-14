package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class AttendanceCorrectionRequest implements Serializable{
	
	private Integer attendanceId;
	
	private String status;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime startTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime endTime;
	
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime breakTime;
	
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime operatingTime;
	
	@NotEmpty(message = "修正理由を入力してください")
	private String reason;
	
	private String remarks;
	
	private Integer userId;
}
