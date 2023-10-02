//package com.example.demo.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.Data;
//
////出勤情報
//
//@Data
//@Entity
//@Table(name = "attendance" , schema = "public")
//public class AttendanceEntity{
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "userid")
//	private Integer userid;
//	
//	@Column(name = "status")
//	private String status;
//	
//	@Column(name = "start_day")
//	private String start_day;
//	
//	@Column(name = "start_time")
//	private String start_time;
//	
//	@Column(name = "remarks")
//	private String remarks;
//
//	public void setUserid(String userid2) {
//		// TODO 自動生成されたメソッド・スタブ
//		
//	}
//
//	public void setAttendance_id(Object attendance_id) {
//		// TODO 自動生成されたメソッド・スタブ
//		
//	}
//}