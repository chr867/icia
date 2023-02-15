package com.board.icia.dao;

import java.util.ArrayList;

import com.board.icia.dto.BoardDto;

public interface IBoardDao {

	ArrayList<BoardDto> getBoardList(Integer pageNum);
	
}
