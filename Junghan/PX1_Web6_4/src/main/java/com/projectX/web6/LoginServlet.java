package com.projectX.web6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        
        String username = request.getParameter("username");
        
        // 세션 생성 또는 기존 세션 가져오기
        HttpSession session = request.getSession();
        System.out.print(session.getId());
        
        if(session.isNew()) {
        	System.out.print("새로운 세션 객체가 생성됨");
		} else {
			System.out.print("기존의 세션 객체가 리턴됨");
		}
        
        // 아이디를 세션에 저장 
        session.setAttribute("username", username);
        
        // 입력한 아이디 출력
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("<h2>로그인 성공!</h2>");
        response.getWriter().println("<h4>입력한 아이디: " + username + "</h4>");
        
        //로그아웃하기 링크
        response.getWriter().println("<a href=\"LogoutServlet\">로그아웃하기</a>");
    }

}
