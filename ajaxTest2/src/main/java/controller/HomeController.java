package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getServletPath();
		System.out.println("cmd:"+cmd);
		if(cmd.equals("/test")) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			request.setAttribute("id", id);
			request.setAttribute("pw", pw);		
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
