//package com.example.demo.service;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.dto.LeavingRequest;
//import com.example.demo.entity.LeavingEntity;
//import com.example.demo.repository.LeavingRepository;
//
////Service
//@Service
//@Transactional(rollbackFor = Exception.class)
//public class LeavingService{
//
////Repository
//	@Autowired
//	private LeavingRepository leavingRepository;
//	
//	
////退勤新規登録
//	public void create(LeavingRequest leavingRequest) {
//		Date now = new Date();
//	    LeavingEntity leaving = new LeavingEntity();
//		leaving.setUserid(leavingRequest.getUserid());
//		leaving.setStatus(leavingRequest.getStatus());
//		leaving.setEnd_day(leavingRequest.getEnd_day());
//		leaving.setEnd_time(leavingRequest.getEnd_time());
//		leaving.setBreak_time(leavingRequest.getBreak_time());
//		leaving.setAttendance_id(leavingRequest.getAttendance_id());
//		leavingRepository.save(leaving);
//	}
//}
