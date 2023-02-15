package com.board.icia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.board.icia.dao.IMemberDao;
import com.board.icia.dao.MemberDao;
import com.board.icia.dto.MemberDto;
import com.board.icia.dto.MemberDto.join;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MemberMM {
	@Autowired
//	private MemberDao mDao;
	private IMemberDao mDao;
	
	public MemberDto.access access(MemberDto.access mb) {
		//복호화는 안되지만 비교는 가능
		BCryptPasswordEncoder pwEncoder=new BCryptPasswordEncoder();
		if(mDao.getSecurityPw(mb.getM_id())!= null){
			if(pwEncoder.matches(mb.getM_pw(),mDao.getSecurityPw(mb.getM_id()))) {
				log.info("로그인 성공");
				return mDao.getMemberInfo(mb.getM_id());
			}else {
				log.info("비번 오류");
				return null;
			}
		}else {
			log.info("아이디 오류");
			return null;
		}
	}

	public boolean join(MemberDto.join mb) {
//		Encoder(암호화)<--> Decoder(복호화)
//		스프링은 복호화 불가능
		BCryptPasswordEncoder pwEncoder=new BCryptPasswordEncoder();
		mb.setM_pw(pwEncoder.encode(mb.getM_pw())); //1111->암호화
		return mDao.join(mb);
	}
	
}
