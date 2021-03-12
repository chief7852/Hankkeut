package board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.InquiryBoardVO;
import vo.MemberVO;
import vo.freeBoardVO;

public class InquiryDaoImpl implements IInquiryDao {
	private static InquiryDaoImpl dao = null;
	private SqlMapClient smc;
	
	private InquiryDaoImpl() {
		smc = SqlMapClientFactory.getClient();
	}
	public static IInquiryDao getDao() {
		if(dao == null) dao = new InquiryDaoImpl();
		return dao;
	}

	@Override
	public List<InquiryBoardVO> selectAll() {
		List<InquiryBoardVO> boardList = null;
		try {
			boardList = smc.queryForList("inquiry.selectAll");
		} catch (Exception e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public List<InquiryBoardVO> selectByPage(Map<String, Integer> map) {
		
		List<InquiryBoardVO> boardList = null;
		try {
			boardList = smc.queryForList("inquiry.selectByPage", map);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public int insertBoard(InquiryBoardVO vo) {
		int cnt = 0;
		Object insert = null;
		try {
			insert = smc.insert("inquiry.insertBoard", vo);
			if(insert == null) cnt = 1;
			else cnt = 0;
		} catch (SQLException e) {
			insert = null;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public InquiryBoardVO selectBoard(int boardNum) {
		
		InquiryBoardVO nBoardVo = null;
		try {
			nBoardVo = (InquiryBoardVO)smc.queryForObject("inquiry.selectBoard", boardNum);
		} catch (SQLException e) {
			nBoardVo = null;
			e.printStackTrace();
		}
		return nBoardVo;
	}
	@Override
	public int selectAllCnt() {
		int cnt = 0;
		try {
			cnt = (int) smc.queryForObject("inquiry.selectAllCnt");
		} catch (SQLException e) {
			cnt =0 ;
			e.printStackTrace();
		}
		return cnt;
	}


}
