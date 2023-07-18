package com.projectX.web6;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveCookieServlet
 */
@WebServlet("/SaveCookieServlet")
public class SaveCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 한글 데이터 처리를 위한 인코딩 설정
        request.setCharacterEncoding("UTF-8");
        
        // 상품 이름 파라미터 가져오기
        String product = request.getParameter("product");
        
        
        // 저장된 모든 쿠키 가져오기
        Cookie[] cookies = request.getCookies();
        
        // 기존에 같은 이름의 쿠키가 있는지 확인하기
        boolean found = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
            	String compName = URLDecoder.decode(cookie.getName(),"utf-8");
                if (compName.equals(product + "Name")) {
                    // 같은 이름의 쿠키가 존재하면 값을 갱신할 것
                    cookie.setValue(product);
                    response.addCookie(cookie);
                    found = true;
                    break;
                }
            }
        }
        
        // 쿠키 생성
        if (!found) {
        	Cookie cookie = new Cookie(URLEncoder.encode(product + "Name","utf-8"), URLEncoder.encode(product,"utf-8"));
        
	        // 쿠키 유효기간 설정 
	        cookie.setMaxAge(60*60*3);  // 3 hours
	        cookie.setPath("/"); 
	        // 쿠키 추가 
	        response.addCookie(cookie);
        }
        // 저장 완료 메시지 출력
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("<h2>와우!! 쿠키 저장되었습니다!</h2>");
        
        // 입력 페이지로 이동할 수 있도록 링크 설정 
        response.getWriter().println("<a href=\"/\">이전 입력 페이지로 이동하기 </a>");
    
	}
}
