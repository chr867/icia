package com.board.icia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.icia.dao.IMemberDao;
import com.board.icia.dto.MemberDto;

@Service
public class MemberMM {
	@Autowired
	private IMemberDao mDao;
	
	public boolean access(MemberDto.access mb) {
		return mDao.access(mb);
	}
	
}
