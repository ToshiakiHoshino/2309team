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
//public class LeavingEntity{
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "userid")
//	private Integer userid;
//	
//	@Column(name = "status")
//	private String status;
//	
//	@Column(name = "end_day")
//	private String end_day;
//	
//	@Column(name = "end_time")
//	private String end_time;
//	
//	@Column(name = "remarks")
//	private String remarks;
//	
//	@Column(name = "Break_time")
//	private String break_time;
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