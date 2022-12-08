package com.example.petShop1.notice;

import java.util.List;

import com.example.petShop1.notice.Board;

public interface BoardService {
	public void register(Board board, String id) throws Exception;
	
	public List<Board> list() throws Exception;
	
	public Board read(Integer bodid) throws Exception;
	
	public void modify(Board board) throws Exception;
	
	public void remove(Integer bodid) throws Exception;
}
