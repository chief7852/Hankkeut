package backmusic.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.BackMusicVO;

public class BackmusicDaoImpl implements IBackmusicDao {
	
	private static IBackmusicDao dao = null;
	private SqlMapClient smc;
	
	public BackmusicDaoImpl() {
		smc = SqlMapClientFactory.getClient();
	}
	
	public static IBackmusicDao getDao() {
		if(dao == null) dao = new BackmusicDaoImpl();
		return dao;
	}

	@Override
	public List<BackMusicVO> selectAll() {
		List<BackMusicVO> list = null;
		
		try {
			list = smc.queryForList("backmusic.ListAllMusic");
		} catch (SQLException e) {
			list = null;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
