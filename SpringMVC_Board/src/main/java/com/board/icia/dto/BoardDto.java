package com.board.icia.dto;


import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@Alias("board")
public class BoardDto {
 private int b_num;
 private String b_title;
 private String b_contents;
 private String b_id;
 private Timestamp b_date; //(String 가능 
 private int b_views;
}
	