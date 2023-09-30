package com.example.demo.entity;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
	 * ユーザー情報 Entity
 * @param <Varchar>
	 */
	@Entity
	@Data
	@Table(name = "attendance")
	public class MonthListEntity<Varchar> {
		
	    /**
	     * ユーザーID
	     */
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id")
	    private Integer user_id;
	    /**
	     * ステータス
	     */
	    @Column(name = "status")
	    private Varchar status;
	    /**
	     * 出勤日
	     */
	    @Column(name = "start_date")
	    private Date start_date;
	    /**
	     * 出勤時間
	     */
	    @Column(name = "start_time")
	    private Time start_time;
	    /**
	     * 退勤日
	     */
	    @Column(name = "end_date")
	    private Date end_date;
	    /**
	     * 退勤時間
	     */
	    @Column(name = "end_time")
	    private Time end_time;
	    /*
	     * 備考
	     */
	    @Column(name = "remarks")
	    private Varchar remarks;
	    /**
	     * 休憩時間
	     */
	    @Column(name = "break_time")
	    private Time break_time;
	    /**
	     * 勤怠ID
	     */
	    @Column(name = "attendance_ID")
	    private Integer attendance_ID;
	}
