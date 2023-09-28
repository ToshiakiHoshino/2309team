package com.example.demo.service;

import com.example.demo.entity.Autowired;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeExample;
import com.example.demo.entity.EmployeeMapper;
import com.example.demo.entity.Service;
import com.example.demo.entity.UserDetails;
import com.example.demo.entity.UserDetailsService;
import com.example.demo.entity.UsernameNotFoundException;

public class MypageService {


	/***
	 * ログインイン時に認証ユーザーを「employeeテーブル」から情報を取得するクラス
	 */
	@Service
	public class LoginUserDetailsService implements UserDetailsService {
	}
	    @Autowired
	    EmployeeExample employeeExample;

	    @Autowired
	    EmployeeMapper employeeMapper;

	    @Override
	    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
	        //入力された名前をキーにemployeeテーブルのレコードを1件取得
	        Employee employee = employeeMapper.selectByName(name);

	        //該当レコードが取得できなかった場合はエラーにする
	        if  (employee   ==  null)   {
	            throw new UsernameNotFoundException("Wrong email or password");
	        }

}
