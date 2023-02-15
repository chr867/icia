package com.board.icia.dto;

import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.Data;
//bean : DTO(Data Transfer Object): view-->Service(DTO->entity)-->DAO(DB)
//		entity  DB(table,DAO)-->Service(entity->DTO)-->View
//		VO(Value Object):getter()만
@Data
@Alias("member")
//@Builder
public class MemberDto {
	
	@Data
	@Alias("member")
	public static class access { //로그인용 DTO
		private String m_id;
		private String m_pw;
		private String m_name;
		private String m_birth;
		private String m_addr;
		private String m_phone;
		private String m_grade;

//		public MemberDto toEntity() {
//			return Member.builder().m_id(m_id);
//		}
	}
	
	@Data
	@Alias("member")
	public static class join { //회원가입용 DTO
		private String m_id;
		private String m_pw;
		private String m_name;
		private String m_birth;
		private String m_addr;
		private String m_phone;
//		public MemberDto toEntity() {
//			return Member.builder().m_id(m_id);
//		}
	}

}