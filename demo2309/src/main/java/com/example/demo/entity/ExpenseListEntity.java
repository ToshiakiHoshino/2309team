package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Data
@Entity
@Table(name = "expenses_table")
public class ExpenseListEntity {
	/**
	 * UserID
	 */
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	/**
	 * 申請日
	 */
	@Column(name = "application_date")
	private Date applicationDate;
	/**
	 * 項目
	 */
	@Column(name = "item")
	private String item;
	/**
	 * 金額
	 */
	@Column(name = "price")
	private Integer price;
	/**
	 * 備考
	 */
	@Column(name = "remarks")
	private String remarks;
}