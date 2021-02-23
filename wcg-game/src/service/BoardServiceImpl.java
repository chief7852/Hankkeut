package service;

import java.util.List;
import java.util.Map;

import dao.BoardDaoImpl;
import dao.IBoardDao;
import vo.BoardVO;
import vo.noticeBoardVO;

public class BoardServiceImpl implements IBoardService{
	private static IBoardService service = null;
	
	private IBoardDao dao;
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getDao();
	}
	public static IBoardService getService() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}
	
	@Override
	public List<noticeBoardVO> selectAll() {
		return dao.selectAll();
	}
	
	
}
