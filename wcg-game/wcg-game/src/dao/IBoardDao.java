package dao;

import java.util.List;
import java.util.Map;

import vo.BoardVO;

public interface IBoardDao {
	// 전체 리스트 출력
	public List<BoardVO> selectAll();
	
	// 페이지별 목록 가져오기
	public List<BoardVO> selectByPage(Map<String, Integer> map);
	
	// 게시글 저장하기
	public int insertBoard(BoardVO vo);
	
	// 게시글 수정하기
//	public int updateBoard(BoardVO vo);
	
	// 게시글 삭제하기
	public int deleteBoard(int num);
	
	// 댓글 저장하기
	
	// 댓글 수정하기
	
	// 댓글 삭제하기
	
	// 조회수 증가
	
	// 전체글 갯수 가져오기
	public int listCount();
}
