package com.board.icia.dao;

import com.board.icia.dto.MemberDto;

public interface IMemberDao {

	boolean access(MemberDto.access mb);
	
	boolean join(MemberDto.join mb);

	String getSecurityPw(String m_id);

	MemberDto.access getMemberInfo(String m_id);

}
