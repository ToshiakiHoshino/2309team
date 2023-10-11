package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class AttendanceCorrectionRequest implements Serializable{
	
	private Integer attendanceId;
	
	private String status;
	
	private LocalDate startDate;
	
	private LocalTime startTime;
	
	private LocalDate endDate;
	
	private LocalTime endTime;
	
	private LocalTime breakTime;
	
	private LocalTime operatingTime;
	
	@NotNull(message = "修正理由を入力してください")
	private String reason;
	
	private String remarks;
}
