package com.board.icia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.icia.dao.IBoardDao;

@Service
public class BoardMM {
	@Autowired
	private IBoardDao bDao;
}
