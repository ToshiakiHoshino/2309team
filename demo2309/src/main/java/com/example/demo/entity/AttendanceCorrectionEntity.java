package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "attendance")
public class AttendanceCorrectionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendance_ID")
	private Integer attendanceId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "start_time")
	private LocalTime startTime;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Column(name = "end_time")
	private LocalTime endTime;
	
	@Column(name = "break_time")
	private LocalTime breakTime;
	
	@Column(name = "operating_time")
	private LocalTime operatingTime;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "remarks")
	private String remarks;
	
	@Column(name = "user_id")
	private Integer userId;
}
