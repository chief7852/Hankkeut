package preference.service;

import java.sql.SQLException;

import preference.dao.IPreferenceDao;
import preference.dao.PreferenceDaoImpl;

public class preferenceServiceImpl implements IPreferenceService {

	private static IPreferenceService service = null;
	
	private IPreferenceDao dao;
	
	private preferenceServiceImpl() {
		dao = PreferenceDaoImpl.getDao(); 
	}
	
	public static IPreferenceService getService() {
		if(service == null)
			service = new preferenceServiceImpl();
		return service;
	}
	
	
	@Override
	public int updateautoready(String mem_id, int num) {
		int vo = 0;
		
		try {
			vo = dao.updateautoready(mem_id, num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}

	
}
