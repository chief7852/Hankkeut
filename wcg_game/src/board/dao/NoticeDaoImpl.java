package board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.noticeBoardVO;

public class NoticeDaoImpl implements INoticeDao { 
	
	private static INoticeDao dao = null;
	private SqlMapClient smc;
	
	private NoticeDaoImpl () {
		smc = SqlMapClientFactory.getClient();
	}
	public static INoticeDao getDao() {
		if(dao == null) dao = new NoticeDaoImpl();
		return dao;
	}

	@Override
	public List<noticeBoardVO> selectAll() {
		List<noticeBoardVO> boardList = null;
		try {
			boardList = smc.queryForList("notice.selectAll");
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
			cnt = (Integer) smc.queryForObject("notice.selectAllCnt");
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public List<noticeBoardVO> selectByPage(Map<String, Integer> map) {
		List<noticeBoardVO> boardList = null;
		try {
			boardList = smc.queryForList("notice.selectByPage", map);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	@Override
	public int insertBoard(noticeBoardVO vo) {
		int cnt = 0;
		Object insert = null;
		try {
			insert = smc.insert("notice.insertBoard", vo);
			if(insert == null) cnt = 1;
			else cnt = 0;
		} catch (SQLException e) {
			insert = null;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public noticeBoardVO selectBoard(int boardNum) {
		noticeBoardVO nBoardVo = null;
		try {
			nBoardVo = (noticeBoardVO) smc.queryForObject("notice.selectBoard", boardNum);
		} catch (SQLException e) {
			nBoardVo = null;
			e.printStackTrace();
		}
		return nBoardVo;
	}
	@Override
	public int updateBoard(noticeBoardVO vo) {
		int cnt = 0;
		try {
			cnt = smc.update("notice.updateBoard", vo);
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
			cnt = smc.delete("notice.deleteBoard", boardNum);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int updateViews(int boardNum) {
		int cnt = 0;
		try {
			cnt = smc.update("notice.updateViews", boardNum);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

}
