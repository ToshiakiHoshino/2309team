package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.LeavingRequest;
import com.example.demo.entity.AttendanceEntity;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.repository.LeavingRepository;

//Service
@Service
@Transactional(rollbackFor = Exception.class)
public class LeavingService {

	//Repository
	@Autowired
	private LeavingRepository leavingRepository;
	
	@Autowired
    private AttendanceRepository attendanceRepository;


	//全検索
	public List<AttendanceEntity> searchAll() {
		return leavingRepository.findAll();
	}
//
//	//ID検索
//	public AttendanceEntity findById(Integer attendance_id) {
//		return leavingRepository.findById(attendance_id).get();
//	}
	
//	//出勤時間取得
//	public LocalTime findAttendanceTimeById(Integer attendance_id) {
//        AttendanceEntity attendanceEntity = attendanceRepository.findById(attendance_id).orElse(null);
//        if (attendanceEntity != null) {
//            return attendanceEntity.getStart_time();
//        } else {
//            return null; // レコードが見つからなかった場合の処理
//        }
//    }

	//退勤新規登録(更新）
	public void update(LeavingRequest leavingRequest) {
		AttendanceEntity leaving = leavingRepository.findOne(leavingRequest.getAttendance_id());
//		leaving.setUser_id(leavingRequest.getUser_id());
		leaving.setStatus(leavingRequest.getStatus());
		leaving.setEnd_date(leavingRequest.getEnd_date());
		leaving.setEnd_time(leavingRequest.getEnd_time());
		leaving.setBreak_time(leavingRequest.getBreak_time());
		
//		//稼働時間
//		// 1.年月日時分秒をセット
//		LocalDateTime date1 = LocalDateTime.of(leavingRequest.getStart_date(), leavingRequest.getStart_time());
//		// 2.年月日時分秒をセット
//		LocalDateTime date2 = LocalDateTime.of(leavingRequest.getEnd_date(), leavingRequest.getEnd_time());
//		// 2.年月日時分秒をセット
//	    LocalDateTime date3 = LocalDateTime.of(leavingRequest.getEnd_date(), leavingRequest.getBreak_time());
//		
//		Duration date4 = Duration.between(date1, date2);// 合計稼働時間を取得する
//		Duration date5 = date4.minus(Duration.between(LocalDateTime.of(0, 1, 1, 0, 0), date3));
//		
//		leaving.setOperetion_time(date5);
//		
		
		
		leavingRepository.save(leaving);
	}

}