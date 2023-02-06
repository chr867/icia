package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;

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
}
