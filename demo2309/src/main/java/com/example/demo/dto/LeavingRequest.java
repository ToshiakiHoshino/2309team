package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LeavingRequest implements Serializable {

	/**
	 * ID
	 */
	@NotEmpty(message = "UserIDを入力してください")
	private String userid;

	//ステータス
	@NotEmpty(message = "ステータスを入力してください")
	private String status;

	/**
	 * 退勤日
	 */
	@NotEmpty(message = "退勤日を入力してください")
	private String end_day;

	/**
	 * 退勤時間
	 */
	@NotEmpty(message = "退勤時間を入力してください")
	private String end_time;

	/**
	 * 備考
	 */
	@Size(max = 100, message = "100文字以内で入力してください")
	private String remarks;

	/**
	 * 退勤時間
	 */
	@NotEmpty(message = "休憩時間を入力してください")
	private String break_time;

	//勤怠ID
	public Object getAttendance_id() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public void setAttendance_id(Object attendance_id) {
		// TODO 自動生成されたメソッド・スタブ

	}
}