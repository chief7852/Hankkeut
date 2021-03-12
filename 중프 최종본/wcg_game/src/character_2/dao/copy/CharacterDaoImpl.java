package character_2.dao.copy;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.CharVO;

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
	public CharVO selectChar(String mem_id) throws SQLException {
		CharVO vo = new CharVO();
		vo = (CharVO) client.queryForObject("character.selectChar", mem_id);
		return vo;
	}
	
	@Override
	public int updateBuyPoint(String mem_id,String item) throws SQLException {
		int res;
		
		
		//System.out.println("itemitemitemitemitem"+ item);
		
				
		Map<String, String> map = new HashMap<String, String>();
		map.put( "mem_id",mem_id );
		map.put( "item", item );
		
		res = (Integer) client.update("shop.BuyItem",map);
		return res;
	}
	
	
	@Override
	public int updateIMGLink(String mem_id) throws SQLException {
		int res;
		
		res = client.update("character.changeIMG",mem_id);
		return res;
	}
	
	
	@Override
	public List<CharVO> selectAll() {
		List<CharVO> list = null;
				
		try {
			list = client.queryForList("character.selectAll");
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}		
		return list;
	}
	@Override
	public int insertChar(CharVO vo) {
		int cnt = 0;
		Object isInsert = null;
		try {
			isInsert = client.insert("character.insertChar", vo);
			if(isInsert == null) cnt = 1;
		} catch (SQLException e) {
			cnt = 0;
			isInsert = null;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public List<CharVO> isOn() {
		List<CharVO> charvo = null;
		try {
			charvo = client.queryForList("character.isOn");
		} catch (SQLException e) {
			charvo = null;
			e.printStackTrace();
		}
		return charvo;
	}
	@Override
	public int onChar(String memId) {
		int cnt = 0;
		try {
			cnt = client.update("character.onChar", memId);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int offChar(String memId) {
		int cnt = 0;
		try {
			cnt = client.update("character.offChar", memId);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public int delChar(String mem_id) {
		int cnt = 0;
		try {
			cnt = client.delete("character.delChar", mem_id);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public CharVO selectchetChar(String nickName) {
		CharVO charvo = null;
		try {
			charvo = (CharVO) client.queryForObject("character.selectchetChar", nickName);
		} catch (SQLException e) {
			charvo = null;
			e.printStackTrace();
		}
		return charvo;
	}
	@Override
	public void allUp(String nick) {
		// TODO Auto-generated method stub
		try {
			client.update("character.allUp",nick);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	



}
