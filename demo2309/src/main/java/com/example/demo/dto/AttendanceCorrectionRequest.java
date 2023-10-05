package com.example.demo.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AttendanceCorrectionRequest implements Serializable{
	
	private Long userId;
	
	private String status;
	
	private Date startDate;
	
	private Time starTime;
	
	private Date endDate;
	
	private Time endTime;
	
	private Time breakTime;
	
	@NotEmpty(message = "修正理由を入力してください")
	private String reasons;
	
	private String remarks;

}
