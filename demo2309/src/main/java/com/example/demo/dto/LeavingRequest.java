package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class LeavingRequest implements Serializable {

	/**
	 * ID
	 */
	@NotNull(message = "UserIDを入力してください")
	private Integer user_id;

	//ステータス
	@NotNull(message = "ステータスを入力してください")
	private String status;

	/**
	 * 退勤日
	 */
	@NotNull(message = "退勤日を入力してください")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate end_date;

	/**
	 * 退勤時間
	 */
	@NotNull(message = "退勤時間を入力してください")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime end_time;

	/**
	 * 備考
	 */
	@Size(max = 100, message = "100文字以内で入力してください")
	private String remarks;

	/**
	 * 退勤時間
	 */
	@NotNull(message = "休憩時間を入力してください")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime break_time;

	//勤怠ID
	//public Object getAttendance_id() {
		// TODO 自動生成されたメソッド・スタブ
		//return null;
	//}

	//public void setAttendance_id(Object attendance_id) {
		// TODO 自動生成されたメソッド・スタブ

	//}
}