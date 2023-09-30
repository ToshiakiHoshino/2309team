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
	@Column(name = "status")
	private String statu;
	
	@Column(name = "start_date")
	private Date startData;
	
	@Column(name = "start_time")
	private Time startTime;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "end_time")
	private Time endTime;
	
	private Time workingTime;
	
	@Column(name = "break_time")
	private Time breakTime;
	
	private String reason;
	
	@Column(name = "remarks")
	private String remarks;
	
}
