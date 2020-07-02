package com.the.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	클라이언트의 요청마다, 해당 요청을 처리하는 컨트롤러를 일일이 매핑하면, 유지 보수성이 떨어지고 업무 비효율적이므로,
 	클라이언트의 요청은 일단 하나의 진입점으로 몰아서 처리해야 한다..(대형 어플리케이션에서..)
 	
 	이 클래스에서는 웹사이트의 모든~ 요청을 받을꺼임!!
 */
public class DispatcherServlet extends HttpServlet{
	Properties props;
	
	//서블릿이 인스턴스화 될때, 컨테이너로부터 호출되는 초기화 메서드!!
	//따라서 개발자는 init()에 초기화 작업코드를 작성해 넣으면 된다!!
	FileInputStream fis;
	
	public void init(ServletConfig config) throws ServletException {
		ServletContext context=config.getServletContext(); //jsp에서의 application 내장객체!!
		String mappingPath=context.getRealPath("/WEB-INF/mapping.data"); //linux, window, unix 맞게...
		//어플리케이션의 전역적 정보를 갖고있기 때문에, 웹어플리케이션내의 자원의 위치등을 반환해주기도 한다!!
		
		props=new Properties();
		try {
			fis=new FileInputStream(mappingPath);
			props.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("나 호출?");
				
		//받은 요청을 분석해보자!!(영화?, 혈액형?, 핸드폰?, 세탁기..etc) uri > url 범위차이!!
		String uri = request.getRequestURI();
		System.out.println("당신이 요청한 URI는 "+uri);
		
		Controller controller =null;
		Class controllerClass =null;
		
		String className=(String)props.get(uri); //검색 ->여러번 일어남
			
		try {
			controllerClass = Class.forName(className);
			controller=(Controller)controllerClass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		controller.execute(request, response);
		
		//클라이언트에게 보여질 결과 페이지(뷰) 셋팅
		RequestDispatcher dis = null;
		String viewPage=(String) props.get(controller.getViewName());
		dis=request.getRequestDispatcher(viewPage);
		System.out.println("검색된 결과 페이지: "+viewPage);
		
		//생성된 포워딩 객체를 이용하여, 전달!!
		dis.forward(request, response);
	}
	
	//서블릿의 인스턴스가 소멸할때 호출되는 메서드!!
	public void destroy() {
		if(fis!=null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}



































