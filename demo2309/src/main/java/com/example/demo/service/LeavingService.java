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

//		LocalTime startTime = leavingRequest.getStart_time();
//		LocalTime endTime = leavingRequest.getEnd_time();
//		LocalTime breakTime = leavingRequest.getBreak_time();
//
//		LocalTime workHours = calculateWorkHours(startTime, endTime, breakTime);
//		System.out.println("稼働時間: " + workHours);

		//		LocalTime workHours = startTime　- endTime + breakTime
		//        // 出勤時間と退勤時間の間の期間を計算します。
		//        Duration duration = Duration.between(startTime, endTime);
		//
		//        // 休憩時間の分だけ期間から減算します。
		//        long breakMinutes = breakTime.getHour() * 60 + breakTime.getMinute(); // 休憩時間を分に変換
		//        duration = duration.minus(breakMinutes, ChronoUnit.MINUTES);
		//
		//        // DurationをLocalTimeに変換するには、一日の開始点を基準にしてDurationを加算します。
		//        LocalTime workHours = LocalTime.MIDNIGHT.plus(duration);
		//        
		//        System.out.println("稼働時間: " + workHours);
		//		leaving.setOperatingTime(workHours);


		leavingRepository.save(leaving);
	}

//	public static LocalTime calculateWorkHours(LocalTime startTime, LocalTime endTime, LocalTime breakTime) {
//		// 出勤時間と退勤時間の間の期間を計算します。
//		Duration workDuration = Duration.between(startTime, endTime);
//
//		// ここで、workDurationが負の値を持つ可能性があることに注意してください。
//		// それは、endTimeがstartTimeよりも前にある場合です。このケースを適切に処理する必要があります。
//
//		// 休憩時間のDurationを取得します。休憩時間が1時間以下の場合に適用されます。
//		Duration breakDuration = Duration.ofHours(breakTime.getHour()).plusMinutes(breakTime.getMinute());
//
//		// 実際の稼働時間を計算します（休憩時間を引く）。
//		Duration actualWorkDuration = workDuration.minus(breakDuration);
//
//		// DurationをLocalTimeに変換します。
//		int hours = (int) actualWorkDuration.toHours();
//		int minutes = (int) actualWorkDuration.toMinutesPart(); // Java 9以降が必要です。それ以前のバージョンでは別の方法を使ってください。
//
//		// 生成された時間をLocalTimeオブジェクトとして取得します。
//		LocalTime workHours = LocalTime.of(hours, minutes);
//
//		return workHours;
	}
