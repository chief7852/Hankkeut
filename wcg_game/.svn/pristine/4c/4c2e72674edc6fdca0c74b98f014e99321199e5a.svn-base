package board.service;

import java.util.List;
import java.util.Map;

import vo.CommentVO;
import vo.freeBoardVO;
import vo.noticeBoardVO;

public interface IFreeService {
	

	//자유게시판 전체 리스트 
	public List<freeBoardVO> selectAll();
	
	// 자유게시판 전체 리스트 개수
	public int selectAllCnt();
	
	// 자유게시판 페이징 처리를 위한 메소드
	public List<freeBoardVO> selectByPage(Map<String, Integer> map);
	
	// 자유게시판조회수 증가
	public int updateViews(int boardNum);
	
	// 자유게시판해당 게시물 내용
		public freeBoardVO selectBoard(int boardNum);
		
		
		// 자유게시판 등록
		public int insertBoard(freeBoardVO vo);
		// 자유게시판  수정
		public int updateBoard(freeBoardVO vo);
		// 자유게시판 삭제
		public int deleteBoard(int boardNum);
		

		// 댓글 등록
		public int insertReply(CommentVO vo);
}
