package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

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
		String id=req.getSession().getAttribute("id").toString();
		
		String str="";
		if(id.equals("admin")) {
			str+="<div><a href='memberlist'>관리자 모드(회원 목록)</a></div>";
		}else {
			str+="<div><a href=\"memberinfo?id="+id+"\">내 정보 확인</a></div>";
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
		req.getSession().invalidate();
		Forward fw=new Forward();
		fw.setPath("./");
		fw.setRedirect(true);
		return fw;
	}

	public Forward memberList() {
		MemberDao mDao=new MemberDao();
		ArrayList<String> mList=mDao.memberList();
		mDao.close();
		Forward fw=new Forward();
		if(mList != null) {
//			req.setAttribute("mList", makeListHtml(mList));
//			req.setAttribute("mList", mList); //jstl
			Gson gson=new Gson();
			String json=gson.toJson(mList); //자바객체 --> json
//			System.out.println("json="+json);
			req.setAttribute("mListJson", json);
			fw.setPath("memberList.jsp");
			fw.setRedirect(false);
		}else {
			fw.setPath("main.jsp");
			fw.setRedirect(true);
		}
		return fw;
	}

	private String makeListHtml(ArrayList<String> mList) {
		StringBuilder sb=new StringBuilder();
		sb.append("<table border='1'>");
		for(int i=0;i<mList.size();i++) {
			System.out.println(mList.get(i));
			sb.append("<tr align='center'>");
			sb.append("<td><a href='memberinfo?id="+mList.get(i)+"'>"+mList.get(i)+"</a></td>");
			sb.append("<td><a href='memberdelete?id="+mList.get(i)+"'>삭제</a></td>");
			sb.append("</tr>");
		}
		sb.append("</table>");
	
//		Iterator<String> i=mList.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
//		
//		for (String string : mList) {
//			
//		}
		
		return sb.toString();
	}

	public Forward memberDelete() {
		Forward fw=new Forward();
		MemberDao mDao=new MemberDao();
		boolean result=mDao.memberDelete(req.getParameter("id"));
		mDao.close();
		if(result) {
			fw.setPath("memberList.jsp").setRedirect(true);
		}else {
			req.setAttribute("msg", "삭제 실패");
			fw.setPath("memberList.jsp").setRedirect(false);
		}
		return fw;
	}

	public Forward memberInfo() {
		Forward fw=new Forward();
		MemberDao mDao=new MemberDao();
		HashMap<String, String> hMap=mDao.memberInfo(req.getParameter("id"));
		mDao.close();
		if(hMap!=null) {
//			req.setAttribute("hMap", hMap);
			String json=new Gson().toJson(hMap);
			req.setAttribute("mb", json);
			fw.setPath("memberInfo.jsp").setRedirect(false);
		}else {
			req.setAttribute("msg", "정보 검색 실패");
			fw.setPath("memberInfo.jsp").setRedirect(true);
		}
		return fw;
	}
	
}
