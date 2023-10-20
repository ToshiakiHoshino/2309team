package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class AttendanceRequest implements Serializable {
	/**
	 * ID
	 */
	private Integer user_id;

	//ステータス
	@NotNull(message = "ステータスを入力してください")
	private String status;

	/**
	 * 出勤日
	 */
	@NotNull(message = "出勤日を入力してください")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate start_date;
	/**
	 * 出勤時間
	 */
	@NotNull(message = "出勤時間を入力してください")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime start_time;
	/**
	 * 備考
	 */
	@Size(max = 100, message = "100文字以内で入力してください")
	private String remarks;

	/**
	 * 勤怠ID
	 */
	private Integer attendance_id;
}