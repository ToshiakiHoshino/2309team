package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.UserEntity;
import com.example.demo.dto.UserRegistrationRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.service.UserService;




/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {

	/**
	 * ユーザー情報 Service
	 */

	@Autowired
	private UserService userService;

	/**
	 * ユーザー新規登録画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping("/user/add")
	public String displayAdd(Model model) {
		model.addAttribute("userRegistrationRequest", new UserRegistrationRequest());
		return "UserRegistration";
	}


	/**
	 * ユーザー新規登録
	 * @param userRequest
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@PostMapping("/user/create")
	public String create(@ModelAttribute @Validated UserRegistrationRequest userRegistrationRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			model.addAttribute("userRegistrationRequest", userRegistrationRequest);

			return "UserRegistration";
		}
		// ユーザー情報の登録
		userService.create(userRegistrationRequest);
		return "user/mypage";
	}


	/**
	 * ユーザー編集画面を表示
	 * @param 表示するユーザーID
	 * @param model Model				
	 * @return ユーザー編集画面
	 */
	@GetMapping("/user/{userid}/edit")
	public String displayEdit(@PathVariable Integer userid, Model model) {
		UserEntity user = userService.findById(userid);
		UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
		userUpdateRequest.setUserid(user.getUserid());
		userUpdateRequest.setName(user.getName());
		userUpdateRequest.setFurigana(user.getFurigana());
		userUpdateRequest.setAddress(user.getAddress());
		userUpdateRequest.setPassword(user.getPassword());
		model.addAttribute("userUpdateRequest", userUpdateRequest);
		return "UserEdit";
	}

	  /**
	   * ユーザー更新
	   * @param userRequest
	   * @param model Model
	   * @return ユーザー情報詳細画面
	   */
	  @PostMapping("/user/update")
	  public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	      List<String> errorList = new ArrayList<String>();
	      for (ObjectError error : result.getAllErrors()) {
	        errorList.add(error.getDefaultMessage());
	      }
	      model.addAttribute("validationError", errorList);
	      return "UserEdit";
	    }
	    // ユーザー情報の更新
	    userService.update(userUpdateRequest);
	    return String.format("user/mypage", userUpdateRequest.getUserid());
	  }

	
	/**
	   * ユーザー情報削除
	   * @param 表示するユーザーID
	   * @param model Model
	   * @return ユーザー情報詳細画面
	   */
	  @GetMapping("/user/{userid}/delete")
	  public String delete(@PathVariable Integer userid, Model model) {
	    // ユーザー情報の削除
	    userService.delete(userid);
	    return "user/mypage";
	  }
	

}