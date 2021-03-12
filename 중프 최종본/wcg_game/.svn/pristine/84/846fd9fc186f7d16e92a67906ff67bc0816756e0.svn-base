package preference.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.preferenceVO;

public class PreferenceDaoImpl implements IPreferenceDao {

	private SqlMapClient client;
	private static IPreferenceDao dao;
	
	public PreferenceDaoImpl() {
		client = SqlMapClientFactory.getClient();
	}
	
	public static IPreferenceDao getDao() {
		if(dao == null) dao = new PreferenceDaoImpl();
		return dao;
	}
	
	
	   @Override
	   public int updateautoready(String mem_id,String num) throws SQLException {
	      int res;
	      Map<String, String> map = new HashMap<String, String>();
	      
	      map.put("num", num);
	      map.put("mem_id", mem_id);
	   
	      res = client.update("preference.selectAutoready",map);
	      
	      System.out.println("res"+res);
	      return res; 
	   }

	@Override
	public preferenceVO isFriendMess(String mem_id) {
		preferenceVO prevo = null;
		try {
			prevo = (preferenceVO) client.queryForObject("preference.isFriendMess", mem_id);
		} catch (SQLException e) {
			prevo = null;
			e.printStackTrace();
		}
		return prevo;
	}

	@Override
	public int insertPre(String mem_id) {
		int cnt = 0; Object insert = null;
		try {
			insert = client.insert("preference.insertPre", mem_id);
			if(insert == null) cnt = 1;
			else cnt = 0;
		} catch (SQLException e) {
			cnt = 0;
			insert = null;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int delPre(String mem_id) {
		int cnt = 0;
		try {
			cnt = client.delete("preference.delPre", mem_id);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

}
