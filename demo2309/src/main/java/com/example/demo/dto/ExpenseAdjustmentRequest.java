package com.example.demo.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ExpenseAdjustmentRequest implements Serializable{
	
	private Integer expenseId;
	
	private Date applicationDate;
	
	private String item;
	
	private Integer price;
	
	@NotEmpty(message = "修正理由を記入してください")
	@Size(max = 100, message = "理由は100桁以内で入力してください")
	private String remarks;
	
}