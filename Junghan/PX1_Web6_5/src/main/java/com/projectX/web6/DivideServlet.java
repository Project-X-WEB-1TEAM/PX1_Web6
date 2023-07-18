package com.projectX.web6;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DivideServlet
 */
@WebServlet("/DivideServlet")
public class DivideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int numerator;
    private int denominator;
    private double result;

    // Setter method
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    // Getter method
    public double getResult() {
        return result;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 데이터 파싱 후, INT변환 
            int numerator = Integer.parseInt(request.getParameter("numerator"));
            int denominator = Integer.parseInt(request.getParameter("denominator"));

            setNumerator(numerator);
            setDenominator(denominator);
          
            result = this.numerator / this.denominator;
            
            // result페이지로 넘겨줄 result값 속성저장
            request.setAttribute("result", result);
            
            RequestDispatcher view = request.getRequestDispatcher("/result.jsp");
            view.forward(request, response);         
            
        } catch (ArithmeticException e) {
            response.sendRedirect("error.jsp");
        }
    }
}
