package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ExpenseAdjustmentRequest implements Serializable{
	
	@NotNull(message = "経費IDを入力してください")
	private Integer expenseId;
	
	@NotNull(message="申請日を選択してください")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate applicationDate;
	
	@NotEmpty(message = "項目を入力してください")
	private String item;

	@NotNull(message = "金額を入力してください")
	private Integer price;
	
	@NotEmpty(message = "備考を記入してください")
	@Size(max = 100, message = "備考は100桁以内で入力してください")
	private String remarks;
	
}