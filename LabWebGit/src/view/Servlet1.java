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
		
		long time = System.currentTimeMillis();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>Servlet1:"+time+"</h3>");
//		long time = System.currentTimeMillis();
		long time1 = (long)(Math.random()*10000);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out1 = response.getWriter();
		out1.println("<h1>Servlet1:"+time1+"</h1>");
		long time2 = System.currentTimeMillis();
		response.setContentType("text/html; charset=UTF-8");
		out1.println("<h3>Servlet1:"+time2+"</h3>");
		out1.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
