package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "user")
public class ExpenseAdjustmentEntity {
  /**
   * ID
   */
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * 名前
   */
  @Column(name = "name")
  private String name;
  /**
   * 住所
   */
  @Column(name = "address")
  private String address;
  /**
   * 電話番号
   */
  @Column(name = "phone")
  private String phone;
  /**
   * 更新日時
   */
  @Column(name = "update_date")
  private Date updateDate;
  /**
   * 登録日時
   */
  @Column(name = "create_date")
  private Date createDate;
  /**
   * 削除日時
   */
  @Column(name = "delete_date")
  private Date deleteDate;
  
}
