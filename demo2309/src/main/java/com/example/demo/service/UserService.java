package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.UserRegistrationRequest;
import com.example.demo.dto.UserUpdateRequest;


/**
 * ユーザー情報 Service
 * @param <UserEntity>
 */
/**@Transactional(rollbackFor = Exception.class)*/

@Service
public class UserService {
	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private UserRepository UserRepository;

	/**
	 * ユーザー情報 新規登録
	 * @param user ユーザー情報
	 */
	public void create(UserRegistrationRequest userRegistrationRequest) {
		UserEntity userRegistration = new UserEntity();
		userRegistration.setUserid(userRegistrationRequest.getUserid());
		userRegistration.setName(userRegistrationRequest.getName());
		userRegistration.setFurigana(userRegistrationRequest.getFurigana());
		userRegistration.setAddress(userRegistrationRequest.getAddress());
		userRegistration.setPassword(userRegistrationRequest.getPassword());
		UserRepository.save(userRegistration);
	}


	/**
	 * ユーザー情報 全検索
	 * @return 検索結果
	 */
	public List<UserEntity> searchAll() {
		return UserRepository.findAll();
	}

	/**
	 * ユーザー情報 主キー検索
	 * @return 検索結果
	 */
	public UserEntity findById(Integer id) {
		return UserRepository.getOne(id);
	}
	/**
	 * ユーザー情報 更新
	 * @param ユーザー情報
	 */
	public void update(UserUpdateRequest userUpdateRequest) {
		UserEntity user = findById(userUpdateRequest.getUserid()); 
		user.setAddress(userUpdateRequest.getAddress());
		user.setName(userUpdateRequest.getName());
		user.setFurigana(userUpdateRequest.getFurigana());
		user.setPassword(userUpdateRequest.getPassword());
		UserRepository.save(user);
	}
	
	 /**
	   * ユーザー情報 削除
	   * @param ユーザーID
	   */
	  public void delete(Integer id) {
	    UserEntity user = findById(id);
	    UserRepository.delete(user);
	  }
}
