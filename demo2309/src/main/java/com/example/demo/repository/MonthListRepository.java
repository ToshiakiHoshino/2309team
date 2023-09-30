package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MonthListEntity;

/**
	 * ユーザー情報 Repository
	 */
	@Repository
	public interface MonthListRepository extends JpaRepository<MonthListEntity, Integer> {
	}