package com.projectX.web6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
        // 세션 가져오기 (false: 세션이 없으면 새로 생성하지 않음)
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // 세션에서 저장된 아이디 삭제 (로그아웃)
            session.removeAttribute("username");
            session.invalidate(); // 현재의 세션을 삭제 (세션 무효화)
        }
        
        // 로그아웃 메시지 출력
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("<h2>로그아웃 성공!</h2>");
        
        //로그인하기 페이지로 링크
        response.getWriter().println("<a href=\"/\">로그인하기</a>");
    }
}
