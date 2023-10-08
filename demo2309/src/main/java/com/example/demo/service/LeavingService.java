package com.example.demo.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceRequest;
import com.example.demo.dto.LeavingRequest;
import com.example.demo.entity.AttendanceEntity;
import com.example.demo.repository.LeavingRepository;

//Service
@Service
@Transactional(rollbackFor = Exception.class)
public class LeavingService {

	//Repository
	@Autowired
	private LeavingRepository leavingRepository;

	//全検索
	public List<AttendanceEntity> searchAll() {
		return leavingRepository.findAll();
	}

	//ID検索
	public AttendanceEntity findById(Integer attendance_id) {
		return leavingRepository.findById(attendance_id).get();
	}

	//退勤新規登録(更新）
	public void update(LeavingRequest leavingRequest,AttendanceRequest attendanceRequest) {
		AttendanceEntity leaving = findById(leavingRequest.getAttendance_id());
		leaving.setUser_id(leavingRequest.getUser_id());
		leaving.setStatus(leavingRequest.getStatus());
		leaving.setEnd_date(leavingRequest.getEnd_date());
		leaving.setEnd_time(leavingRequest.getEnd_time());
		leaving.setBreak_time(leavingRequest.getBreak_time());
		//稼働時間
		// 1.年月日時分秒をセット
		LocalDateTime date1 = LocalDateTime.of(null, attendanceRequest.getStart_time());
		// 2.年月日時分秒をセット
		LocalDateTime date2 = LocalDateTime.of(null, leavingRequest.getEnd_time());
		// 2.年月日時分秒をセット
	    LocalDateTime date3 = LocalDateTime.of(null, leavingRequest.getBreak_time());
		
		Duration date4 = Duration.between(date1, date2);// 合計稼働時間を取得する
		Duration date5 = date4.minusHours(1);// 稼働時間を取得する
		
		leaving.setOperetion_time(date5);
		
		
		
		leavingRepository.save(leaving);
	}

	//private LeavingEntity findById(String userid) {
	// TODO 自動生成されたメソッド・スタブ
	//return null;
	//}

	//クラス宣言
	//Calendar calendar = Calendar.getInstance();
	//calendar.setTime(date);

	//勤務時間
	//calendar.add(Calendar.HOUR_OF_DAY, 4);
	//date = calendar.getTime();

	//休憩時間
	//    calendar.add(Calendar.HOUR_OF_DAY ,1);
	//    date = calendar.getTime();
	//    
	//    
	//    //出勤
	//	LocalDateTime attendance = LocalDateTime.of(2019,12,31,0,0,0);
	//	
	//	//退勤
	//	LocalDateTime leaving = LocalDateTime.of(2019,12,31,0,0,0);

}
