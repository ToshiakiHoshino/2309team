package com.example.demo.entity;





import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//出勤情報

@Data
@Entity
@Table(name = "attendance")
public class AttendanceEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer user_id;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate start_date;
	
	@Column(name = "start_time")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime start_time;
	
	@Column(name = "remarks")
	private String remarks;

	//public void setUser_id(String userid2) {
		// TODO 自動生成されたメソッド・スタブ}

	//public void setAttendance_id(Object attendance_id) {
		// TODO 自動生成されたメソッド・スタ}
}