package com.itwillbs.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.persistence.BoardDAO;

import jdk.internal.org.jline.utils.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class BoardDAOTest {
	
	// DAO 객체 필요 => 객체 주입
	@Inject
	private BoardDAO dao;
	
	
	// 글 쓰기
	//@Test
	public void 글쓰기동작테스트() {
		BoardVO vo = new BoardVO();
		vo.setTitle("공지사항 입니다");
		vo.setContent("주말은 휴무 입니다.");
		vo.setWriter("관리자");
		
		dao.create(vo);
	}
	
	// 글 페이징처리
//	@Test
	public void 페이징처리테스트() {
		List<BoardVO> boardList = dao.listPage();
		
		for(BoardVO vo : boardList) {
			System.out.println(vo.getBno()+" : "+vo.getTitle());
		}
	}
	
	// 글 페이징처리2
//	@Test
	public void 페이징처리테스트2() {
		List<BoardVO> boardList = dao.listPage(6,10);
		
		for(BoardVO vo : boardList) {
			System.out.println(vo.getBno()+" : "+vo.getTitle());
		}
	}
	
	// 글 페이징처리3
//	@Test
	public void 페이징처리테스트3() {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(5);
		
		List<BoardVO> boardList = dao.listPage(cri);
		
		for(BoardVO vo : boardList) {
			System.out.println(vo.getBno()+" : "+vo.getTitle());
		}
	}

	
	
}
