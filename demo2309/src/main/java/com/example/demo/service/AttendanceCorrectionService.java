package com.example.demo.service;

import java.util.Optional;

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

	public AttendanceCorrectionEntity findById(Integer attendanceId) {
		Optional<AttendanceCorrectionEntity> optionalEntity = attendanceCorrectionRepository.findById(attendanceId);
		return optionalEntity.orElse(new AttendanceCorrectionEntity()); // データが存在しない場合はデフォルト値を返す
	}
	
	public void update(AttendanceCorrectionRequest attendanceCorrectionRequest) {
		AttendanceCorrectionEntity attendanceCorrection = findById(attendanceCorrectionRequest.getAttendanceId());
		attendanceCorrection.setStatus(attendanceCorrectionRequest.getStatus());
		attendanceCorrection.setStartDate(attendanceCorrectionRequest.getStartDate());
		attendanceCorrection.setStartTime(attendanceCorrectionRequest.getStartTime());
		attendanceCorrection.setEndDate(attendanceCorrectionRequest.getEndDate());
		attendanceCorrection.setEndTime(attendanceCorrectionRequest.getEndTime());
		attendanceCorrection.setBreakTime(attendanceCorrectionRequest.getBreakTime());
		attendanceCorrection.setOperatingTime(attendanceCorrectionRequest.getOperatingTime());
		attendanceCorrection.setReason(attendanceCorrectionRequest.getReason());
		attendanceCorrection.setRemarks(attendanceCorrectionRequest.getRemarks());
		attendanceCorrectionRepository.save(attendanceCorrection);
	}
}
