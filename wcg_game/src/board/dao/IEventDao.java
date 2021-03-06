package board.dao;

import java.util.List;

import vo.EventBoardVO;

public interface IEventDao {
	
		//이미지 전체 출력 
		public List<EventBoardVO> selectAll();
		
		//이미지 상세보기 
		public EventBoardVO selectEvent(int boardNum);
		//조회수
		public int updateViews(int boardNum);
		
		//이벤트 인설트
		public int insertEvent(EventBoardVO vo);
}
