package com.the.controller.blood;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.controller.Controller;
import com.the.model.blood.BloodService;


public class BloodController extends Controller{
	
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blood =request.getParameter("blood");
		BloodService bloodService = new BloodService();
		String msg = bloodService.getBlood(blood);
		
		request.setAttribute("msg", msg);// 요청객체의 원하는 데이터를 심는다!!!!(key-value)구조 이다

		RequestDispatcher dis = null;
		dis =request.getRequestDispatcher("/blood2/result.jsp");
		request.setAttribute("msg", msg);
		dis.forward(request, response);
	}
	
	public String getViewName() {
		return "/view/blood";
	}
}





























