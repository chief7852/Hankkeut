package service;

import java.util.List;
import java.util.Map;

import dao.BoardDaoImpl;
import dao.IBoardDao;
import vo.BoardVO;

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
	public List<BoardVO> selectAll() {
		return dao.selectAll();
	}
	@Override
	public int listCount() {
		return dao.listCount();
	}
	@Override
	public List<BoardVO> selectByPage(Map<String, Integer> map) {
		return dao.selectByPage(map);
	}
	@Override
	public int insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}
	@Override
	public int deleteBoard(int num) {
		return dao.deleteBoard(num);
	}
}
