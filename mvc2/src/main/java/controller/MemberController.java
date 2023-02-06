package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;

@WebServlet({"/loginfrm","/access","/joinfrm"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd=req.getServletPath();
		System.out.println("cmd="+cmd);
		MemberMM mm=new MemberMM(req,resp);
		MovingPage mp=new MovingPage(req,resp);
		Forward fw=null;
		if(cmd.equals("/loginfrm")) {
			fw=mp.indexShow();
		}else if(cmd.equals("/joinfrm")) {
			fw=mp.joinFrmShow();
		}
		
		if(fw!=null) {
			if(fw.isRedirect()) {
				resp.sendRedirect(fw.getPath());
			}else {
				req.getRequestDispatcher(fw.getPath());
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}

}
