package board.service;

import java.util.List;

import board.dao.INoticeDao;
import board.dao.NoticeDaoImpl;
import vo.noticeBoardVO;

public class NoticeServiceImpl implements INoticeService {
	
private static INoticeService service = null;
	
	private INoticeDao dao;
	private NoticeServiceImpl() {
		dao = NoticeDaoImpl.getDao();
	}
	public static INoticeService getService() {
		if(service == null) service = new NoticeServiceImpl();
		return service;
	}
	

	@Override
	public List<noticeBoardVO> selectAll() {
		
		return dao.selectAll();
	}
		

}
