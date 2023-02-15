package com.board.icia.service;

import java.util.ArrayList;

import org.apache.ibatis.logging.Log;
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

	public ArrayList<BoardDto> getBoardList(Integer pageNum) {
		ArrayList<BoardDto> bList=new ArrayList<>();
		if(pageNum==null) pageNum=1;
		bList=bDao.getBoardList(pageNum);
		log.info(bList.toString());
		return bList;
	}
}
