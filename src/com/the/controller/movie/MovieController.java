package com.the.controller.movie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.controller.Controller;
import com.the.model.movie.MovieService;

/*
 클라이언트의 요청 중 영화와 관련된 요청을 처리하기위한
 컨트롤러 클래스!! 왜? jsp인 디자인과 로직인 poj를 분리시키기 위해!!
 
  */

public class MovieController extends Controller{
		
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movie=request.getParameter("movie");
		
		//로직은 여기서 짜지말고, 공통코드로 분리시켜놓은 객체를 재사용
		MovieService movieService = new MovieService();
		String msg=movieService.getAdvice(movie);
		
		request.setAttribute("msg", msg);// 요청객체의 원하는 데이터를 심는다!!!!(key-value)구조 이다

		//System.out.println("컨트롤러에서의 결과 "+msg);
		//얻어진 결과를 View인 jsp로 전달해보자!!
		//클라이언트인 브라우저가 재접속할 URL
		
		/*객체는 get방식으로 view에 전달하는 것은 String만 가능하므로, 사용할 수 없다
		
		클라이언트에게 응답처리를 하지말고, 서버상의 또 다른 자원으로 
		흐름의 요청을 이어가자 !! 즉 포워딩(forwarding) 해보자!!
		 */
		
	}
	
	public String getViewName() {
		
		return "/view/movie";
	}
}




























