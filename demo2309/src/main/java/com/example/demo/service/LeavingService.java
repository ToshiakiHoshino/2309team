package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.LeavingRequest;
import com.example.demo.entity.LeavingEntity;
import com.example.demo.repository.LeavingRepository;

//Service
@Service
@Transactional(rollbackFor = Exception.class)
public class LeavingService {

	//Repository
	@Autowired
	private LeavingRepository leavingRepository;

	//全検索
	public List<LeavingEntity> searchAll() {
		return leavingRepository.findAll();
	}
	
	//主キー検索
	public LeavingEntity findById(Integer user_id) {
		return leavingRepository.findById(user_id).get();
	}

	//退勤新規登録(更新）
	public void update(LeavingRequest leavingRequest) {
		LeavingEntity leaving = findById(leavingRequest.getUser_id());
		leaving.setUser_id(leavingRequest.getUser_id());
		leaving.setStatus(leavingRequest.getStatus());
		leaving.setEnd_date(leavingRequest.getEnd_date());
		leaving.setEnd_time(leavingRequest.getEnd_time());
		leaving.setBreak_time(leavingRequest.getBreak_time());
		leavingRepository.save(leaving);
	}

	//private LeavingEntity findById(String userid) {
	// TODO 自動生成されたメソッド・スタブ
	//return null;
	//}

	//稼働時間

}
