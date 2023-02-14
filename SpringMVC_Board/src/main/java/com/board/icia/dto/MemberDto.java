package com.board.icia.dto;

import lombok.Builder;
import lombok.Data;
//bean : DTO(Data Transfer Object): view-->Service(DTO->entity)-->DAO(DB)
//		entity  DB(table,DAO)-->Service(entity->DTO)-->View
//		VO(Value Object):getter()만
@Data
@Builder
public class MemberDto {
	
	@Data
	public static class access { //로그인용 DTO
		private String m_id;
		private String m_pw;
//		public MemberDto toEntity() {
//			return Member.builder().m_id(m_id);
//		}
	}
	public static class join { //로그인용 DTO
		private String m_id;
		private String m_name;
		private String m_addr;
		private String m_pw;
//		public MemberDto toEntity() {
//			return Member.builder().m_id(m_id);
//		}
	}

}