package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/ajax-test")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getServletPath();
		System.out.println("cmd:"+cmd);
		HashMap<String, String> hMap=new HashMap<>();
		if(cmd.equals("/ajax-test")) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			hMap.put("id", id);
			hMap.put("pw", pw);
			//DB
		}
		
//		동기 : 포워딩
//		request.getRequestDispatcher("jq_ajax.jsp").forward(request,response); 
//		비동기 : 결과만 돌려줌
		response.setContentType("text/html;charset=utf-8");
		String json=new Gson().toJson(hMap);
		response.getWriter().write(json);
	 }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
