package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//	マイページのコントローラー
	
	@Controller
	public class MypageController {
		
		//マイページ
		@GetMapping("/mypage")
		public String mypage(Model model) {
	    	return "mypage";
	    }
		
		  //出勤報告への遷移
		    @RequestMapping("/attendance")
		    public String attendance(Model model) {
		    	return "attendance";
		    }
		    
		  //退勤報告への遷移
		    @RequestMapping("/leaving")
		    public String leaving(Model model) {
		        return "leaving";
		    }
		    
		  //勤怠一覧への遷移
		    @RequestMapping("/attendance_list")
		    public String attendance_list(Model model) {
		        return "attendance_list";
		    }
		    
		    //勤怠修正への遷移
		    @RequestMapping("/attendance_revies")
		    public String attendance_revies(Model model) {
		        return "attendance_revies";
		    }
		    
		    //経費申請への遷移
		    @RequestMapping("/expenseClaim")
		    public String expenseClaim(Model model) {
		        return "expenseClaim";
		    }
		    
		    //経費一覧への遷移
		    @RequestMapping("/expenseList")
		    public String expenseList(Model model) {
		        return "expenseList";
		    }
		    
	}
