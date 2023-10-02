package com.example.demo.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ExpenseAdjustmentRequest implements Serializable{
	
	private Long expensesId;
	
	private Long userId;
	
	private Date applicationDate;
	
	private String item;
	
	private Integer price;
	
	@NotEmpty(message = "修正理由を記入してください")
	private String remarks;
}