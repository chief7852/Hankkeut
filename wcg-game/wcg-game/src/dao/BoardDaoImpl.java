package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.BoardVO;

public class BoardDaoImpl implements IBoardDao{
	private static IBoardDao dao = null;
	private SqlMapClient smc;
	
	private BoardDaoImpl () {
		smc = SqlMapClientFactory.getClient();
	}
	public static IBoardDao getDao() {
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}
	
	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> boardList = null;
		try {
			boardList = smc.queryForList("board.selectAll");
			System.out.println("boardList : " + boardList);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	@Override
	public int listCount() {
		int cnt = 0;
		try {
			cnt = (Integer) smc.queryForObject("board.listCount");
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public List<BoardVO> selectByPage(Map<String, Integer> map) {
		List<BoardVO> boardList = null;
		try {
			boardList = smc.queryForList("board.selectByPage",map);
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	@Override
	public int insertBoard(BoardVO vo) {
		int cnt = 0;
		try {
			cnt = (Integer) smc.insert("board.insertBoard",vo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int deleteBoard(int num) {
		int cnt = 0;
		try {
			cnt = smc.delete("board.deleteBoard", num);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

}
