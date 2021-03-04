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
	public int updateautoready(String mem_id,int num) throws SQLException {
		int res;
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("num", num);
		map.put("mem_id", mem_id);
	
		
		res = client.update("preference.selectAutoready",map);
		return res;
	}

}
