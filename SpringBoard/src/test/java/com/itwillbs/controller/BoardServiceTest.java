package com.itwillbs.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;
import com.itwillbs.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class BoardServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceTest.class);
	
	@Inject
	private BoardService service;
	
	@Test
	public void 글쓰기서비스테스트() {
		log.info(" 서비스 테스트 ");
		BoardVO vo = new BoardVO();
		vo.setTitle(" 1번 글 ");
		vo.setContent(" 1번 글 내용 ");
		vo.setWriter(" 작성자1 ");
		
		service.boardCreate(vo);
		log.info(" Service-글쓰기 완료!");
	}
	
	
	
}
