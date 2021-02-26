package board.service;

import java.util.List;
import java.util.Map;

import board.dao.FreeDaoImple;
import board.dao.IFreeDao;
import vo.CommentVO;
import vo.freeBoardVO;

public class FreeServiceImpl implements IFreeService {
	
	private static IFreeService service = null;
	private IFreeDao dao;
	private FreeServiceImpl() {
		dao = FreeDaoImple.getDao();
	}
	public static IFreeService getService() {
		if(service == null) service = new FreeServiceImpl();
		return service;
	}

	@Override
	public List<freeBoardVO> selectAll() {		
		return dao.selectAll();
	}
	@Override
	public int selectAllCnt() {
		return dao.selectAllCnt();
		
	}
	@Override
	public List<freeBoardVO> selectByPage(Map<String, Integer> map) {
		
		return dao.selectByPage(map);
	}
	@Override
	public int updateViews(int boardNum) {
		
		return dao.updateViews(boardNum);
	}
	@Override
	public freeBoardVO selectBoard(int boardNum) {
		
		return dao.selectBoard(boardNum);
	}
	@Override
	public int insertBoard(freeBoardVO vo) {
		
		return dao.insertBoard(vo);
	}
	@Override
	public int updateBoard(freeBoardVO vo) {
		// TODO Auto-generated method stub
		return dao.updateBoard(vo);
	}
	@Override
	public int deleteBoard(int boardNum) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(boardNum);
	}
	@Override
	public int insertReply(CommentVO vo) {
		
		return dao.insertReply(vo);
	}

}
