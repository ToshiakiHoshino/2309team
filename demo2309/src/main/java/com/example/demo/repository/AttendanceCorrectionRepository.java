package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AttendanceCorrectionEntity;

public interface AttendanceCorrectionRepository extends JpaRepository<AttendanceCorrectionEntity, Integer> {
}
