package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;
import bean.Member;
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
			session.setAttribute("accessresult", makeResultHtml());
			fw.setPath("main.jsp").setRedirect(false);
		}else {
			req.setAttribute("msg", "<b>로그인 실패.</b>");
			fw.setPath("./").setRedirect(false);
		}
		return fw;
	}

	private Object makeResultHtml() {
		HttpSession session=req.getSession();
		String str="";
		if(session.getAttribute("id").equals("admin")) {
			str+="<div><a href='memberlist'>멤버 목록</a></div>";
		}else {
			str+="<div><a href='memberinfo'>자기 정보</a></div>";
		}
		return str;
	}

	private String makeLogoutHtml() {
		String str="";
		str+="<div><a href='logout'>로그아웃</a></div>";
		return str;
	}

	public Forward memberjoin() {
		Member mb = new Member();
		mb.setId(req.getParameter("id"));
		mb.setPw(req.getParameter("pw"));
		mb.setName(req.getParameter("name"));
		mb.setGender(req.getParameter("gender"));

		// DB 비지니스 로직 DAO
		MemberDao mDao = new MemberDao();
		// DB접속
		boolean result = mDao.memberJoin(mb);
		// DB종료
		mDao.close();

		Forward fw = new Forward();
		if (result) {
			fw.setPath("index.jsp");
			fw.setRedirect(true);
		} else {
			req.setAttribute("msg", "회원가입실패"); // ${msg}
			fw.setPath("joinFrm.jsp");
			fw.setRedirect(false);
		}
		return fw;
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
