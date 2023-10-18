package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * 経費申請 リクエストデータ
 */
@Data
public class ExpenseClaimRequest implements Serializable {

	private Integer expense_id;
	/**
	 * User ID
	 */
	@NotNull(message = "User IDを入力してください")
	private Integer user_id;
	
	/**
	 * 申請日
	 */
	@NotNull(message = "申請日を入力してください")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate application_date;
	
	/**
	 * 項目
	 */
	@NotEmpty(message = "項目を入力してください")
	@Size(max = 50, message = "項目は50文字以内で入力してください")
	private String item;
	
	/**
	 * 金額
	 */
	@NotNull(message = "金額を入力してください")
	@PositiveOrZero(message = "正しい金額を入力してください")
	private Integer price;
	
	/**
	 * 備考
	 */
	@Size(max = 100, message = "備考は100文字以内で入力してください")
	private String remarks;
}