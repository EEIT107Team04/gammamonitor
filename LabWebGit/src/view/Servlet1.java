package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		long time = System.currentTimeMillis();
		long time1 = (long)(Math.random()*10000);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Servlet1:"+time1+"</h1>");
		long time2 = System.currentTimeMillis();
		response.setContentType("text/html; charset=UTF-8");
		out.println("<h3>Servlet1:"+time2+"</h3>");
		out.close();
		
	  測試 測試 這次測試 May 27 2019 16:36 
		
	  
	  test test test 1 2 3,  one two three
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
