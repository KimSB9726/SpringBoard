package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	// 디비연결 및 mapper 연결처리 객체
	@Inject
	private SqlSession sqlSession;
	
	static final String NAMESPACE="com.itwillbs.mapper.BoardMapper";
	
	// 디비연결 및 mapper 연결처리 객체
	
	// 글쓰기
	@Override
	public void create(BoardVO vo) {
		// 정보 전달 받아서 mapper를 거쳐서 DB에 저장
		log.info(" 글쓰기 정보 전달 받아서 mapper 호출 ");
		sqlSession.update(NAMESPACE+".alterbno", vo);
		sqlSession.insert(NAMESPACE+".createBoard", vo);
		log.info(" 글쓰기 완료!!! ");
	}
	
	// 글목록
	@Override
	public List<BoardVO> listAll() {
		log.info(" listAll() 호출 ");
		// mapper 해당 sql 호출
		List<BoardVO> boardList = sqlSession.selectList(NAMESPACE+".listAll");
		log.info(" 글목록 불러오기 완료!!! ");
		return boardList;
	}
	
	// 글 본문
	@Override
	public BoardVO getBoard(Integer bno) {
		log.info(" getBoard(bno) 호출 ");
		// mapper에 있는 sql 호출
		BoardVO vo = sqlSession.selectOne(NAMESPACE+".getBoard", bno);
		log.info(" 글 본문 불러오기 완료!!! ");
		return vo;
	}

	
	// 글 본문 수정하기
	@Override
	public void updateBoard(BoardVO vo) {
		log.info(" updateBoard(vo) 호출 ");
		// mapper - sql 호출
		sqlSession.update(NAMESPACE+".updateBoard", vo);
		log.info(" 글 본문 수정하기 완료!!! ");
		
	}

	
	// 글 삭제하기
	@Override
	public void removeBoard(Integer bno) {
		log.info(" removeBoard(bno) 호출 ");
		// mapper - sql 호출
		sqlSession.delete(NAMESPACE+".deleteBoard", bno);
		log.info(" 글 삭제하기 완료!!! ");
	}
	
	
	// 글 조회수 증가
	@Override
	public void updateBoardCount(Integer bno) {
		log.info(" viewcnt(viewcnt) 호출 ");
		// mapper - sql 호출
		sqlSession.update(NAMESPACE+".updateBoardCnt", bno);
		log.info(" 글 조회수 1증가!!! ");
	}

	@Override
	public List<BoardVO> listPage() {
		log.info(" listPage() 호출 ");
		return sqlSession.selectList(NAMESPACE+".listPage");
	}

	@Override
	public List<BoardVO> listPage(int page, int size) {
		log.info(" listCri() 호출 ");
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		if(page <= 0) {
			page = 1;
		}
		
		if(size <= 0) {
			size = 10;
		}
		
		page = (page - 1) * size;
		
		param.put("pageStart", page);
		param.put("perPageNum", size);
		
		return sqlSession.selectList(NAMESPACE+".listCri", param);
	}

	
	@Override
	public List<BoardVO> listPage(Criteria cri) {
		
		return sqlSession.selectList(NAMESPACE+".listCri", cri);
	}

	
	
	
	
	
}
