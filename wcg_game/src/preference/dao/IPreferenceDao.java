package preference.dao;

import java.sql.SQLException;

public interface IPreferenceDao {
	
	//autoready update
	public int updateautoready(String mem_id,int num) throws SQLException;
	
}
