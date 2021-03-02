package manager.dao;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.ManagerVO;
import vo.MemberVO;
import vo.noticeBoardVO;

public class ManagerDaoImpl implements IManagerDao {
	
	private SqlMapClient client;
	private static IManagerDao dao;
	
	private ManagerDaoImpl () {
		client = SqlMapClientFactory.getClient();
	}
	public static IManagerDao getDao() {
		if(dao == null) dao = new ManagerDaoImpl();
		return dao;
	}
	@Override
	public String comparison(ManagerVO vo) {
		//ManagerVO manVo = null;
		String manVo = null;
		try {
			manVo = (String) client.queryForObject("manager.comparison", vo);
		} catch (SQLException e) {
			manVo = null;
			e.printStackTrace();
		}
		return manVo;
	}
	
	

}
