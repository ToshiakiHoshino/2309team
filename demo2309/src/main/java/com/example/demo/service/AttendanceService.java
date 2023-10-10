package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceRequest;
import com.example.demo.entity.AttendanceEntity;
import com.example.demo.repository.AttendanceRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class AttendanceService{

	//Repository
	@Autowired
	private AttendanceRepository attendanceRepository;

	//出勤新規登録
	public void create(AttendanceRequest attendanceRequest) {
		Date now = new Date();
		AttendanceEntity attendance = new AttendanceEntity();
		attendance.setUser_id(attendanceRequest.getUser_id());
		attendance.setStatus(attendanceRequest.getStatus());
		attendance.setStart_date(attendanceRequest.getStart_date());
		attendance.setStart_time(attendanceRequest.getStart_time());
		attendance.setAttendance_id(attendanceRequest.getAttendance_id());

		attendanceRepository.save(attendance);
	}
}
