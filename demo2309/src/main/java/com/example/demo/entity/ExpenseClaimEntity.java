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
@Entity
@Data
@Table(name = "expenses_table")
public class ExpenseClaimEntity {
  /**
   * UserID
   */
  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;
 
  /**
   * 申請日
   */
  @Column(name = "application_date", nullable = false)
  private Date applicationDate;
  /**
   * 項目
   */
  @Column(name = "item,  length = 100, nullable = false")
  private String item;
  /**
   * 金額
   */
  @Column(name = "price, nullable = false")
  private Integer price;
  /**
   * 備考
   */
  @Column(name = "remarks", length = 100)
  private String remarks;
}