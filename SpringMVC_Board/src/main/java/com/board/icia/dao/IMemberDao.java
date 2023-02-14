package com.board.icia.dao;

import com.board.icia.dto.MemberDto;

public interface IMemberDao {

	boolean access(MemberDto.access mb);
	
	boolean join(MemberDto.join mb);
}
