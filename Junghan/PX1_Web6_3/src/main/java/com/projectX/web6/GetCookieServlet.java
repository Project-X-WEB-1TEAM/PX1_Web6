package com.projectX.web6;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieServlet
 */
@WebServlet("/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
        // 브라우저에 저장된 모든 쿠키 가져오기
	    Cookie[] cookies = request.getCookies();
	    
	    // 브라우저 화면에 출력
	    response.setContentType("text/html; charset=UTF-8");
	    response.getWriter().println("<h2>저장된 모든 쿠키 목록 :</h2>");
	    
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            response.getWriter().println("<h4> 쿠키 이름: " + URLDecoder.decode(cookie.getName(),"utf-8") + ", 쿠키 값: " + URLDecoder.decode(cookie.getValue(),"utf-8")  + "</h4>");
	        }
	    } else {
	        response.getWriter().println("<h4> 아쉽네요. 저장된 쿠키가 없습니다.</h4>");
	    }
	    
	    // 이전 페이지로 이동
	    response.getWriter().println("<a href=\"/\">이전 입력 페이지로 이동하기 </a>");
    }

}
