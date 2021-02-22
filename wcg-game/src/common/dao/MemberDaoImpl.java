package common.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;

import vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {

	
	private SqlMapClient client;
	private static IMemberDao dao;
	
	
	
	
	
	private MemberDaoImpl () {
		client = SqlMapClientFactory.getClient();
	}
	public static IMemberDao getDao() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public String insertMember(MemberVO vo) throws SQLException {
		
		return (String)client.insert("member.insertMember", vo);
	}

	@Override
	public int deleteMember(String mem_id) {
		int cnt = 0;
		try {
			cnt = (Integer) client.delete("board.deleteBoard",mem_id);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public String selectById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return (String) client.queryForObject("member.selectById",id);
	}

}
