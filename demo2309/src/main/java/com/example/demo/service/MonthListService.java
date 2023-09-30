package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MonthListEntity;
import com.example.demo.repository.MonthListRepository;

/**
 * ユーザー情報 Service
 */
@Service
public class MonthListService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private MonthListRepository monthListRepository;
  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<MonthListEntity> searchAll() {
    return monthListRepository.findAll();
  } 
}
