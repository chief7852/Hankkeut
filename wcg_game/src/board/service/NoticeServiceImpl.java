package board.service;

import java.util.List;
import java.util.Map;

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
	@Override
	public int selectAllCnt() {
		return dao.selectAllCnt();
	}
	@Override
	public List<noticeBoardVO> selectByPage(Map<String, Integer> map) {
		return dao.selectByPage(map);
	}
	@Override
	public int insertBoard(noticeBoardVO vo) {
		return dao.insertBoard(vo);
	}
	@Override
	public noticeBoardVO selectBoard(int boardNum) {
		return dao.selectBoard(boardNum);
	}
	@Override
	public int updateBoard(noticeBoardVO vo) {
		return dao.updateBoard(vo);
	}
	@Override
	public int deleteBoard(int boardNum) {
		return dao.deleteBoard(boardNum);
	}
	@Override
	public int updateViews(int boardNum) {
		return dao.updateViews(boardNum);
	}
		

}
