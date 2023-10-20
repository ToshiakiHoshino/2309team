package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.LeavingRequest;
import com.example.demo.entity.AttendanceCorrectionEntity;
import com.example.demo.repository.LeavingRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class LeavingService {

	@Autowired
	private LeavingRepository leavingRepository;

	//
	//	//ID検索
	public AttendanceCorrectionEntity findById(Integer attendance_id) {
		return leavingRepository.findById(attendance_id).get();
	}


	//退勤新規登録(更新）
	public void update(LeavingRequest leavingRequest) {
		AttendanceCorrectionEntity leaving = leavingRepository.findById(leavingRequest.getAttendance_id()).orElseThrow();
		leaving.setUserId(leavingRequest.getUser_id());
		leaving.setStatus(leavingRequest.getStatus());
		leaving.setEndDate(leavingRequest.getEnd_date());
		leaving.setEndTime(leavingRequest.getEnd_time());
		leaving.setBreakTime(leavingRequest.getBreak_time());
		leaving.setRemarks(leavingRequest.getRemarks());


		leavingRepository.save(leaving);
	}
	
//	/**
//     * 出勤時間と退勤時間の間の稼働時間を計算します（1時間の休憩時間を除く）。
//     *
//     * @param startTime 出勤時間
//     * @param endTime   退勤時間
//     * @return 稼働時間（時間単位）
//     */
//    public long calculateWorkingHours(LocalTime startTime, LocalTime endTime) {
//        // 出勤時間と退勤時間の間の分単位での差を計算します。
//        long totalMinutes = ChronoUnit.MINUTES.between(startTime, endTime);
//        // 休憩時間（1時間＝60分）を差し引きます。
//        long workingMinutes = totalMinutes - 60; // 1時間の休憩
//        //S 分を時間単位に変換します。小数点以下は切り捨てます。
//        long workingHours = workingMinutes / 60;
//        return workingHours;
//        
//        leavingRepository.save(leaving);
//    }
}