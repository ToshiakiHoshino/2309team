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

//出勤情報

@Data
@Entity
@Table(name = "attendance" , schema = "public")
public class LeavingEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer user_id;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "end_date")
	private LocalDate end_date;
	
	@Column(name = "end_time")
	private LocalTime end_time;
	
	@Column(name = "remarks")
	private String remarks;
	
	@Column(name = "Break_time")
	private LocalTime break_time;

	//public void setUserid(String userid2) {
		// TODO 自動生成されたメソッド・スタブ
		
	//}

	//public void setAttendance_id(Object attendance_id) {
		// TODO 自動生成されたメソッド・スタブ
		
	//}
}