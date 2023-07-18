package com.projectx.web6;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MySevlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GET 방식으로 데이터를 처리하는 코드
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식으로 데이터를 처리하는 코드
        processRequest(request, response);
	}
	
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 전송된 데이터의 Encoding을 UTF-8로 지정하여 한글 변경 
        request.setCharacterEncoding("UTF-8");
        
        // 브라우저로 한글 데이터 출력 설정 
        response.setContentType("text/html; charset=UTF-8");
       
        
        // HTTP Header 특정 헤더 정보 조회
        Enumeration<?> em = request.getHeaderNames();
        response.getWriter().println("<h2>HTTP Header 정보:</h2>");

        while (em.hasMoreElements()){
            String s = (String)em.nextElement();
            
            response.getWriter().println("<p>" + s + " : " + request.getHeader(s) + "</p>");

        }
        
        // Request Parameter 로 데이터 조회가능 
        String stuff = request.getParameter("stuff");
        
        response.getWriter().println("<br> <h2>전송된 데이터:</h2>");
        response.getWriter().println("<p> 데이터 : " + stuff + "</p> <br>  ");
    }
}
