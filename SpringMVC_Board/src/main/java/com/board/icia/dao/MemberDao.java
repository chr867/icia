package com.board.icia.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.icia.dto.MemberDto;

@Repository
public class MemberDao {
	
//	@Autowired
//	private SqlSessionTemplate tpl;

//	public boolean access(MemberDto.access mb) {
//		return tpl.selectOne("memberMapper.access",mb);
//	}
}
