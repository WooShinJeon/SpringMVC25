package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper; // db쿼리용 객체
	
	@Override
	public void register(BoardVO board) {
		
		log.info("BoardServiceImpl.register 메서드 실행......");
		
		mapper.insertSelectKey(board);
		log.info("정상등록 후 리스트 출력테스트......");
		mapper.getList2();
	}
	
	@Override
	public BoardVO get(Long bno) {
		// 게시물의 번호가 들어가면 매퍼의 select문이 동작해야 한다.
		log.info("BoardServiceImpl.get 메서드 실행......");
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// 프론트에서 객체가 넘어오면 매퍼를 통해서 update 뭐리가 실행된다.
		log.info("BoardServiceImpl.modify 메서드 실행......");
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// 프론트에서 번호가 넘어오면 매퍼를 통해서 delete 쿼리가 실행된다.
		log.info("BoardServiceImpl.remove 메서드 실행......");
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		// getList() 메서드가 호출되면 매퍼에 getList2()를 호출한다.
		
		log.info("BoardServiceImpl.getList 메서드 실행......");
		
		return mapper.getList2();
	}
	
}
