package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	// 인터페이스는 클래스와 다르게 메서드가 추상화처럼 되어있다.
	// 추상메서드는 시그니처만 있으며(실행문이 없다.), 그래서 ; 로 끝난다. 
	
	@Select("SELECT * FROM tbl_board WHERE bno > 0")
	public List<BoardVO> getList(); // 추상 메서드
	
	public List<BoardVO> getList2(); // xml을 이용한 쿼리 처리 매퍼용 메서드
	
	public void insert(BoardVO board);			// xml에서 쿼리 작성
	
	public void insertSelectKey(BoardVO board);	// xml에서 쿼리 작성
	
	public BoardVO read(Long bno);				// xml에서 쿼리 작성
	// 번호가 들어가면 객체로 나온다.
	public int delete(Long bno);				// xml에서 쿼리 작성
	// 번호가 들어가면 삭제 후 몇개가 삭제됐는지 리턴한다.
	public int update(BoardVO board);			// xml에서 쿼리 작성
	// 번호가 들어가면 필드 수정 후 몇개가 수정되었는지 리턴한다.
	
}
