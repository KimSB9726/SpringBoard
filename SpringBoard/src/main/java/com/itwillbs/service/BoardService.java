package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

public interface BoardService {
	
	// 글쓰기 동작
	public void boardCreate(BoardVO vo);
	
	// 글 전체 목록 가져오기 동작
	public List<BoardVO> getBoardListAll();
	
	// 글 본문 가져오기 동작
	public BoardVO readBoard(Integer bno);
	
	// 글 본문 수정하기 동작(POST)
	public void updateBoard(BoardVO vo);
	
	// 글 삭제하기 동작(POST)
	public void deleteBoard(Integer bno);
	
	// 글 조회수 1증가
	public void updateBoardCnt(Integer bno);
	
	// 글 페이징 처리
	public List<BoardVO> boardListCri(Criteria cri);
	
}
