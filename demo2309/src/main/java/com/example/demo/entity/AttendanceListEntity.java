package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "attendance")
public class AttendanceListEntity {

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