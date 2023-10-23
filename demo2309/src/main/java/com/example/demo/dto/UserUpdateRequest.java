package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserUpdateRequest implements Serializable {
 /**
  *ユーザーID
  */	
@NotNull(message = "IDを入力してください")
 private Integer userid;	
	
 /**
  * 名前
  */
 @NotNull(message = "名前を入力してください")
 private String name;

 /**
  * フリガナ
  */
 @NotNull(message = "フリガナを入力してください")
 private String furigana;
 
 /**
  * メールアドレス
  */
 @NotNull(message = "メールアドレスを入力してください")
 private String address;

 /**
  * パスワード
  */
 @NotNull(message = "パスワードを入力してください")
 private String password;

}

