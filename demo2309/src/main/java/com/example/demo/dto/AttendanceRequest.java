package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AttendanceRequest implements Serializable {
	/**
	 * ID
	 */
	@NotEmpty(message = "UserIDを入力してください")
	private String userid;

	//ステータス
	@NotEmpty(message = "ステータスを入力してください")
	private String status;

	/**
	 * 出勤日
	 */
	@NotEmpty(message = "UserIDを入力してください")
	private String start_day;
	/**
	 * 出勤時間
	 */
	@NotEmpty(message = "UserIDを入力してください")
	private String start_time;
	/**
	 * 備考
	 */
	@Size(max = 100, message = "100文字以内で入力してください")
	private String remarks;

	//勤怠ID
	public void setAttendance_id(Object attendance_id) {
		// TODO 自動生成されたメソッド・スタブ
		return;
	}

	public Object getAttendance_id() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}