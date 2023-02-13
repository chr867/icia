package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberMM {
	HttpServletRequest req;
	HttpServletResponse resp;
	
	public MemberMM(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;
		
	}

}
