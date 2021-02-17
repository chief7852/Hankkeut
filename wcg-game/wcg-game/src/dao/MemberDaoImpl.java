package dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {

	
	private static IMemberDao dao = null;
	private SqlMapClient smc;
	
	private MemberDaoImpl () {
		smc = SqlMapClientFactory.getClient();
	}
	public static IMemberDao getDao() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	@Override
	public int insertMember(MemberVO vo) {
		int cnt = 0;
		try {
			cnt = (Integer) smc.insert("member.insertMember",vo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String mem_id) {
		int cnt = 0;
		try {
			cnt = (Integer) smc.delete("board.deleteBoard",mem_id);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

}
