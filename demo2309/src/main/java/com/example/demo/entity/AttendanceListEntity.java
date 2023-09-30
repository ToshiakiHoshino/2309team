package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

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

public class AttendanceListEntity  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name =  "name")
	private String name;

	@Column(name = "status")
	private String status;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "start_time")
	private Time startTime;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "end_time")
	private Time endTime;
	
	private Time workingTime;
	
	@Column(name = "break_time")
	private Time breakTime;
	
	@Column(name = "remarks")
	private String remarks;
}
