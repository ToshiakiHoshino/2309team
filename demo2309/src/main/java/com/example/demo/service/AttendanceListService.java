package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AttendanceListEntity;
import com.example.demo.repository.AttendanceListRepository;

@Service
public class AttendanceListService {
	
	@Autowired
	private AttendanceListRepository attendanceListRepository;
	
	
//ユーザー情報検索
	public List<AttendanceListEntity> searchAll() {
		return attendanceListRepository.findAll();
		
	}
	

}
