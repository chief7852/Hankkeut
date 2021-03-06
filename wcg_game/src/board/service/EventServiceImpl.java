package board.service;

import java.util.List;

import board.dao.EventDaoImpl;
import board.dao.FreeDaoImple;
import board.dao.IEventDao;
import board.dao.IFreeDao;
import vo.EventBoardVO;

public class EventServiceImpl implements IEventService {

	private static IEventService service = null;
	private IEventDao dao;
	private EventServiceImpl() {
		dao = EventDaoImpl.getDao();
	}
	public static IEventService getService() {
		if(service == null) service = new EventServiceImpl();
		return service;
	}

	@Override
	public List<EventBoardVO> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public EventBoardVO selectEvent(int boardNum) {
		
		return dao.selectEvent(boardNum);
	}
	@Override
	public int updateViews(int boardNum) {
		
		return dao.updateViews(boardNum);
	}
	@Override
	public int insertEvent(EventBoardVO vo) {
		
		return dao.insertEvent(vo);
	}

}
