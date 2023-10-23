package com.example.demo.entity;

import java.io.Serializable;

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
@Table(name = "user_edit")
public class UserEntity implements Serializable {

	/**
	 *ID
	 */
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer userid;
	/**
	 *名前
	 */
	@Column(name = "name")
	private String name;
	/**
	 *フリガナ
	 */
	@Column(name = "furigana")
	private String furigana;
	/**
	 *メールアドレス
	 */
	@Column(name = "address")
	private String address;
	/**
	 *パスワード
	 */
	@Column(name = "password")
	private String password;

}