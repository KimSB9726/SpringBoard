package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	//DAO 객체 주입
	@Inject
	private BoardDAO dao;
	
	
	// 글 쓰기
	@Override
	public void boardCreate(BoardVO vo) {
		dao.create(vo);
	}


	// 글 목록 
	@Override
	public List<BoardVO> getBoardListAll() {
		List<BoardVO> boardList = dao.listAll();
		return boardList;
	}

	
	// 글 본문 가져오기
	@Override
	public BoardVO readBoard(Integer bno) {
		BoardVO vo = dao.getBoard(bno);
		return vo;
	}


	// 글 본문 수정하기
	@Override
	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
		
	}

	
	// 글 삭제하기
	@Override
	public void deleteBoard(Integer bno) {
		dao.removeBoard(bno);
	}

	
	// 글 조회수 1증가
	@Override
	public void updateBoardCnt(Integer bno) {
		dao.updateBoardCount(bno);
	}

	
	// 글 페이징 처리
	@Override
	public List<BoardVO> boardListCri(Criteria cri) {
		return dao.listPage(cri);
	}
	
	
	
	


	




	
	
	
}
