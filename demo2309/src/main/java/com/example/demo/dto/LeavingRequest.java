package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class LeavingRequest implements Serializable {
	/**
	 * ID
	 */
	private Integer user_id;

	//ステータス
	@NotEmpty(message = "ステータスを入力してください")
	private String status;

	/**
	 * 備考
	 */
	@Size(max = 100, message = "100文字以内で入力してください")
	private String remarks;

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
	 * 休憩時間
	 */
	@NotNull(message = "休憩時間を入力してください")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime break_time;

	/**
	 * 勤怠ID
	 */
	private Integer attendance_id;

	/**
	 * 稼働時間
	 */
	private LocalTime operatoin_time;
	
	/**
	 * 出勤日
	 */
//	@NotNull(message = "出勤日を入力してください")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate start_date;
	
	/**
	 * 出勤時間
	 */
//	@NotNull(message = "出勤時間を入力してください")
//	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime start_time;
}