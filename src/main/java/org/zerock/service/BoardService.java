package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	
	public void register(BoardVO board);	// 게시판 등록용
	
	public BoardVO get(Long bno);			// 게시글 자세히 보기
	// 번호를 넣으면 객체가 나옴
	public boolean modify(BoardVO board);	// 게시글 수정하기
	// 객체가 들어가서 수정이 되었는지 t/f
	public boolean remove(Long bno);		// 게시글 삭제하기
	// 번호가 들어가서 삭제가 되었는지 t/f
	public List<BoardVO> getList();			// 호출되면 리스트타입으로 BoardVO 객체가 넘어옴
	// List : 동적리스트  /  < > 제네릭 : 강제로 객체 타입을 정함.
}
