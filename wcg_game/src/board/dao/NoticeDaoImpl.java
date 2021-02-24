package board.dao;

import java.sql.SQLException;
import java.util.List;

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
			boardList=smc.queryForList("board.selectALL");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return boardList;
	}

}
