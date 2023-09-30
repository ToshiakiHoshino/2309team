package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//	マイページのコントローラー
	
	@Controller
	public class MypageController {
		
		//マイページ
		@GetMapping("/mypage")
		public String mypage(Model model) {
	    	return "mypage";
	    }
		
		  //出勤報告への遷移
		    @PostMapping("/attendance")
		    public String attendance(Model model) {
		    	return "attendance";
		    }
		    
		  //退勤報告への遷移
		    @PostMapping("/leaving")
		    public String leaving(Model model) {
		        return "leaving";
		    }
		    
		  //勤怠一覧への遷移
		    @PostMapping("/attendance_list")
		    public String attendance_list(Model model) {
		        return "attendance_list";
		    }
		    
		    //月別勤怠一覧への遷移
		    @PostMapping("/month_list")
		    public String attendance_revies(Model model) {
		        return "month_list";
		    }
		    
		    //経費申請への遷移
		    @PostMapping("/expenseClaim")
		    public String expenseClaim(Model model) {
		        return "expenseClaim";
		    }
		    
		    //経費一覧への遷移
		    @PostMapping("/expenseList")
		    public String expenseList(Model model) {
		        return "expenseList";
		    }
		    
	}
