package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceCorrectionRequest;
import com.example.demo.entity.AttendanceCorrectionEntity;
import com.example.demo.repository.AttendanceCorrectionRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class AttendanceCorrectionService {
	
	@Autowired
	private AttendanceCorrectionRepository attendanceCorrectionRepository;
	
	public AttendanceCorrectionEntity findById(Long attendanceId) {
	    return attendanceCorrectionRepository.findById(attendanceId).get();
	  }


	
	public void update(AttendanceCorrectionRequest attendanceCorrectionRequest) {
		AttendanceCorrectionEntity attendanceCorrection = findById(attendanceCorrectionRequest.getUserId());
		attendanceCorrection.setStatus(attendanceCorrectionRequest.getStatus());
		attendanceCorrection.setStartData(attendanceCorrectionRequest.getStartDate());
		attendanceCorrection.setStartTime(attendanceCorrectionRequest.getStarTime());
		attendanceCorrection.setEndDate(attendanceCorrectionRequest.getEndDate());
		attendanceCorrection.setEndTime(attendanceCorrectionRequest.getEndTime());
		attendanceCorrection.setBreakTime(attendanceCorrectionRequest.getBreakTime());
		attendanceCorrection.setReason(attendanceCorrectionRequest.getReasons());
		attendanceCorrection.setRemarks(attendanceCorrectionRequest.getRemarks());
		attendanceCorrectionRepository.save(attendanceCorrection);
	}

	

}
