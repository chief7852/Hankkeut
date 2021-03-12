package character.dao;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.CharVO;
import vo.MemberVO;
import vo.ShopVO;
import vo.noticeBoardVO;

public class CharacterDaoImpl implements ICharacterDao {

	
	private SqlMapClient client;
	private static ICharacterDao dao;
	
	
	
	
	
	private CharacterDaoImpl () {
		client = SqlMapClientFactory.getClient();
	}
	public static ICharacterDao getDao() {
		if(dao == null) dao = new CharacterDaoImpl();
		return dao;
	}
	@Override
	public List<CharVO> selectAllChar() throws SQLException {
		List<CharVO> list = null;
		try {
			list = client.queryForList("character.selectAllChar");
		} catch (SQLException e) {
			list = null;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public CharVO selectChar(String mem_id) throws SQLException {
		CharVO vo = new CharVO();
		try {
			
			vo = (CharVO)client.queryForObject("character.selectChar2",mem_id);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return vo;
	}
	@Override
	public int insertChar(CharVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteChar(String nickname) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void onoffChar(String nickname) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void expUpChar(String nickname) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pointUpChar(String nickname) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void oncheckChar(String nickname) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public CharVO selectchetChar(String nick) throws SQLException {
		CharVO vo = new CharVO();
		try {
			
			vo = (CharVO)client.queryForObject("character.selectchetChar",nick);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return vo;
	}
	



}
