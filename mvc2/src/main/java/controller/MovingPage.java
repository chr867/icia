package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;
import dao.MemberDao;

public class MovingPage {
	HttpServletRequest req;
	HttpServletResponse resp;
	Forward fw;
	
	public MovingPage(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;
	}
	
	public Forward indexShow() {
		fw=new Forward();
		fw.setPath("index.jsp").setRedirect(false);
		return fw;
	}
	
	public Forward joinFrmShow() {
		fw=new Forward();
		fw.setPath("joinFrm.jsp").setRedirect(false);
		return fw;
	}

	public Forward access() {
		fw=new Forward();
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		HashMap<String, String> hMap=new HashMap<>(); 
		hMap.put("id", id);
		hMap.put("pw", pw);
		MemberDao mDao=new MemberDao();
		boolean result=mDao.access(hMap);
		mDao.close();
		if(result) {
			HttpSession session=req.getSession();
			session.setAttribute("id", hMap.get("id"));
			session.setAttribute("logout", makeLogoutHtml());
			fw.setPath("main.jsp").setRedirect(true);
		}else {
			req.setAttribute("msg", "<b>로그인 실패.</b>");
			fw.setPath("/").setRedirect(false);
		}
		return fw;
	}

	private String makeLogoutHtml() {
		String str="";
		str+="<div><a href='logout'>로그아웃</a></div>";
		
		return str;
	}

	public Forward memberJoin() {
		return null;
	}

	public Forward logout() {
		return null;
	}

	public Forward memberList() {
		return null;
	}

	public Forward memberDelete() {
		return null;
	}

	public Forward memberInfo() {
		return null;
	}
}
