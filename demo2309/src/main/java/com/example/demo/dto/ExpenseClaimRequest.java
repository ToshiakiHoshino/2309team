package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 経費申請 リクエストデータ
 */
@Data
public class ExpenseClaimRequest implements Serializable {
	/**
	 * User ID
	 */
	
	@NotEmpty(message = "User IDを入力してください")
	private Integer user_id;
	/**
	 * 申請日
	 */
	@NotEmpty(message = "申請日を入力してください")
	@Pattern(regexp = "^[0-9]{4}/[0-9]{2}/[0-9]{2}$", message = "YYYY/MM/DDの形式で入力してください")
	private Date application_date;
	/**
	 * 項目
	 */
	@NotEmpty(message = "項目を入力してください")
	@Size(max = 50, message = "項目は50文字以内で入力してください")
	private String item;
	/**
	 * 金額
	 */
	@NotEmpty(message = "金額を入力してください")
	private Integer price;
	/**
	 * 備考
	 */
	@Size(max = 100, message = "備考は100文字以内で入力してください")
	private String remarks;
}