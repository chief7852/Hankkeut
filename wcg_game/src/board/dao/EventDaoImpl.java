package board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.EventBoardVO;
import vo.InquiryBoardVO;

public class EventDaoImpl implements IEventDao {
	private static EventDaoImpl dao = null;
	private SqlMapClient smc;
	
	private EventDaoImpl() {
		smc = SqlMapClientFactory.getClient();
	}
	
	public static IEventDao getDao() {
		if(dao == null) dao = new EventDaoImpl();
		return dao;
	}
	

	@Override
	public List<EventBoardVO> selectAll() {
		
		List<EventBoardVO> boardList = null;
		try {
			boardList = smc.queryForList("event.selectAll");
			System.out.println("다오임플"+boardList);
		} catch (Exception e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public EventBoardVO selectEvent(int boardNum) {
		EventBoardVO eventboardvo = null;
		try {
			eventboardvo = (EventBoardVO) smc.queryForObject("event.selectEvent",boardNum);
			System.out.println("다오임플 이벤트 셀렉트 new"+eventboardvo);
		} catch (Exception e) {
			eventboardvo = null;
			e.printStackTrace();
		}
		return eventboardvo;
	}

	@Override
	public int updateViews(int boardNum) {
		int cnt = 0;
		try {
			cnt = smc.update("event.updateViews", boardNum);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
		
	}

	@Override
	public int insertEvent(EventBoardVO vo) {
		int cnt=0;
		Object eventboardvo =null;
		try {
			eventboardvo = smc.insert("event.insertEvent",vo);
			if(eventboardvo == null) cnt = 1;
			else cnt = 0;
		} catch (SQLException e) {
			eventboardvo = null;
			e.printStackTrace();
		}
		return cnt;
	}

}
