package com.board.icia.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired //게시판 서비스 클래스
	private BoardMM bm;
	
	@GetMapping("/list")
	public String boardList(HttpSession session) {
//		ArrayList<Board> boardList=bm.getBoardList();
		return "boardList";
	}
}
