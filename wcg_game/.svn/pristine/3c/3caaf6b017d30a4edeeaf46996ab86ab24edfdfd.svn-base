package board.dao;

import java.util.List;
import java.util.Map;

import vo.noticeBoardVO;

public interface INoticeDao {
	// 공지사항 전체 리스트
	public List<noticeBoardVO> selectAll();
	// 공지사항 전체 리스트 개수
	public int selectAllCnt();
	// 공지사항 페이징 처리를 위한 메소드
	public List<noticeBoardVO> selectByPage(Map<String, Integer> map);
	// 해당 게시물 내용
	public noticeBoardVO selectBoard(int boardNum);
	// 공지사항 등록
	public int insertBoard(noticeBoardVO vo);
	// 공지사항 수정
	public int updateBoard(noticeBoardVO vo);
	// 공지사항 삭제
	public int deleteBoard(int boardNum);
	// 조회수 증가
	public int updateViews(int boardNum);
}
