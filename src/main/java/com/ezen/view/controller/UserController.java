package com.ezen.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;
import com.ezen.biz.user.UserService;

@Controller
@SessionAttributes("loginUser")
public class UserController {

	@Autowired
	private UserService userService;
	
	// 로그인 화면 표시
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		
		vo.setId("user1");
		vo.setPassword("user1");
		
		return "login.jsp";
	}
	
	// 사용자 인증
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession session, Model model) {

	    if (vo.getId() == null || vo.getId().equals("")) {
	    	throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
	    }
	    
	    UserVO user = userService.getUser(vo);	// 사용자 정보를 검색한다.

	    // 3.화면 네비게이션
	    if(user != null) {
	    	//session.setAttribute("userName", user.getName());
	    	model.addAttribute("loginUser", user);
	    	
	        return "getBoardList.do";
	    } else {
	        return "login.jsp";
	    }
	}
	
	// 로그아웃
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		// 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
		session.invalidate();
		
		return "login.jsp";	
	}
}







