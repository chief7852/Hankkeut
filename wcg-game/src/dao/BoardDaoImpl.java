package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.BoardVO;
import vo.noticeBoardVO;

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
	public List<noticeBoardVO> selectAll() {
		List<noticeBoardVO> boardList = null;
		try {
			boardList = smc.queryForList("board.selectAll");
			
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}
	

}
