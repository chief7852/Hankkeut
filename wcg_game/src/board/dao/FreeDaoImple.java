package board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.CommentVO;
import vo.freeBoardVO;
import vo.noticeBoardVO;

public class FreeDaoImple implements IFreeDao {
	private static FreeDaoImple dao = null;
	private SqlMapClient smc;
	
	private FreeDaoImple () {
		smc = SqlMapClientFactory.getClient();
	}
	public static IFreeDao getDao() {
		if(dao == null) dao = new FreeDaoImple();
		return dao;
	}

	@Override
	public List<freeBoardVO> selectAll() {
		List<freeBoardVO> boardList = null;
		try {
			boardList = smc.queryForList("free.selectAll");
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}	
		return boardList;
		
	}
	@Override
	public int selectAllCnt() {
		int cnt = 0;
		try {
			cnt = (Integer) smc.queryForObject("free.selectAllCnt");
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public List<freeBoardVO> selectByPage(Map<String, Integer> map) {
		List<freeBoardVO> boardList = null;
		try {
			boardList = smc.queryForList("free.selectByPage", map);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
		
	}
	@Override
	public int updateViews(int boardNum) {
		int cnt = 0;
		try {
			cnt = smc.update("free.updateViews", boardNum);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
		
	}
	@Override
	public freeBoardVO selectBoard(int boardNum) {
		
		freeBoardVO nBoardVo = null;
		try {
			nBoardVo = (freeBoardVO)smc.queryForObject("free.selectBoard", boardNum);
		} catch (SQLException e) {
			nBoardVo = null;
			e.printStackTrace();
		}
		return nBoardVo;
	}
	@Override
	public int insertBoard(freeBoardVO vo) {
		int cnt = 0;
		Object insert = null;
		try {
			insert = smc.insert("free.insertBoard", vo);
			if(insert == null) cnt = 1;
			else cnt = 0;
		} catch (SQLException e) {
			insert = null;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int updateBoard(freeBoardVO vo) {
		int cnt = 0;
		try {
			cnt = smc.update("free.updateBoard", vo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int deleteBoard(int boardNum) {
		int cnt = 0;
		try {
			cnt = smc.delete("free.deleteBoard", boardNum);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int insertReply(CommentVO vo) {
		int cnt = 0;
		try {
			cnt = smc.delete("free.insertReply", vo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	
	}
	@Override
	public List<CommentVO> listReply(String board_no) {
		
		List<CommentVO> nBoardVo = null;
		try {
			nBoardVo = smc.queryForList("free.listReply", board_no);
		} catch (SQLException e) {
			nBoardVo = null;
			e.printStackTrace();
		}
		return nBoardVo;
	}

}
