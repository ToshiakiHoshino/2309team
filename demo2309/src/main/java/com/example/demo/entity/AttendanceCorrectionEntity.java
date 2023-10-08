package com.example.demo.entity;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "attendance")
public class AttendanceCorrectionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "attendance_ID")
	private Long attendanceId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "start_date")
	private Date startData;
	
	@Column(name = "start_time")
	private Time startTime;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "end_time")
	private Time endTime;
	
	@Column(name = "break_time")
	private Time breakTime;
	
	@Column(name = "operating_time")
	private Time operatingTime;
	
	private String reason;
	
	@Column(name = "remarks")
	private String remarks;
	
}
