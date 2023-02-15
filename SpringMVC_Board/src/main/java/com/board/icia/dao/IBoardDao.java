package com.board.icia.dao;

import java.util.List;

import com.board.icia.dto.BoardDto;

public interface IBoardDao {

	List<BoardDto> getBoardList(Integer pageNum);

}
