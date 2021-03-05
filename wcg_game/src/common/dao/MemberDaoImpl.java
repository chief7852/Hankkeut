package common.dao;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;

import vo.MemberVO;
import vo.noticeBoardVO;

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
	public int deleteMember(MemberVO vo) {
		int cnt = 0;
		try {
			cnt = (Integer) client.delete("member.deleteMember",vo);
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
	//로그인
	@Override
	public String loginMember(MemberVO vo) throws SQLException {
		
		return (String) client.queryForObject("member.loginMember",vo);
	}
	@Override
	public MemberVO isMember(MemberVO vo) {
		MemberVO memVo = null;
		try {
			memVo = (MemberVO) client.queryForObject("member.isMember", vo);
		} catch (SQLException e) {
			memVo = null;
			e.printStackTrace();
		}
		return memVo;
	}
	@Override
	public int updatePass(MemberVO vo) {
		int cnt = 0;
		try {
			cnt = client.update("member.updatePass", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public String selectEmail(String memid) {
		String email =null;
		try {
			email = (String) client.queryForObject("member.memid",memid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}
	@Override
	public int isPassWord(MemberVO vo) {
		int cnt = 0;
		try {
			cnt = (int) client.queryForObject("member.isPassWord", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int updatePW(MemberVO vo) {
		int cnt = 0;
		try {
			cnt = (int) client.update("member.updatePW", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int updateAddr(MemberVO vo) {
		int cnt = 0;
		try {
			cnt = (int) client.update("member.updateAddr", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int updateTel(MemberVO vo) {
		int cnt = 0;
		try {
			cnt = (int) client.update("member.updateTel", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public List<MemberVO> guestList() {
		List<MemberVO> memList = null;
		try {
			memList = client.queryForList("member.guestList");
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}
		
		return memList;
	}
	@Override
	public List<MemberVO> memRemoveList() {
		
		List<MemberVO> memList = null;
		try {
			memList = client.queryForList("member.memRemoveList");
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}
		
		return memList;
	}
	


}
