package com.board.icia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.icia.dao.IMemberDao;
import com.board.icia.dao.MemberDao;
import com.board.icia.dto.MemberDto;
import com.board.icia.dto.MemberDto.join;

@Service
public class MemberMM {
	@Autowired
//	private MemberDao mDao;
	private IMemberDao mDao;
	
	public boolean access(MemberDto.access mb) {
		return mDao.access(mb);
	}

	public boolean join(MemberDto.join mb) {
		return mDao.join(mb);
	}
	
}
