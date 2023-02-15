package com.board.icia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.icia.dao.IBoardDao;
import com.board.icia.dto.BoardDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardMM {
	@Autowired
	private IBoardDao bDao;

	public List<BoardDto> getBoardList(Integer pageNum) {
		List<BoardDto> bList=null;
		//if(pageNum==null) pageNum=1;
		bList=bDao.getBoardList(pageNum);
		log.info(bList.toString());
		return bList;
	}
}
