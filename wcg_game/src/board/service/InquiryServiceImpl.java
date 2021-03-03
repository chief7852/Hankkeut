package board.service;

import java.util.List;
import java.util.Map;

import board.dao.FreeDaoImple;
import board.dao.IFreeDao;
import board.dao.IInquiryDao;
import board.dao.InquiryDaoImpl;
import vo.InquiryBoardVO;
import vo.MemberVO;

public class InquiryServiceImpl implements IInquiryService {
	
	private static IInquiryService service = null;
	private IInquiryDao dao;
	
	private InquiryServiceImpl() {
		dao = InquiryDaoImpl.getDao();
	}
	public static IInquiryService getService() {
		if(service == null) service = new InquiryServiceImpl();
		return service;
	}

	@Override
	public List<InquiryBoardVO> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<InquiryBoardVO> selectByPage(Map<String, Integer> map) {
		
		return dao.selectByPage(map);
	}

	@Override
	public int insertBoard(InquiryBoardVO vo) {
	
		return dao.insertBoard(vo);
	}

	@Override
	public InquiryBoardVO selectBoard(int boardNum) {
		
		return dao.selectBoard(boardNum);
	}
	@Override
	public int selectAllCnt() {
	
		return dao.selectAllCnt();
	}
	
	
	
	

}
