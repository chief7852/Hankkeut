package character_2.service.copy;

import java.sql.SQLException;
import java.util.List;

import character_2.dao.copy.CharacterDaoImpl;
import character_2.dao.copy.ICharacterDao;
import vo.CharVO;

public class CharacterServiceImpl implements ICharacterService {
	private static ICharacterService service = null;

	private ICharacterDao dao;

	private CharacterServiceImpl() {
		dao = CharacterDaoImpl.getDao();
	}

	public static ICharacterService getService() {
		if (service == null)
			service = new CharacterServiceImpl();
		return service;
	}


	@Override
	public CharVO selectChar(String mem_id) {
		CharVO vo = new CharVO();
		try {
			vo = dao.selectChar(mem_id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int updateBuyPoint(String mem_id,String item) {
		
		int vo = 0;
		
		try {
			vo = dao.updateBuyPoint(mem_id, item);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}

	
	
	@Override
	public int updateIMGLink(String mem_id) {
		
		int vo = 0;
		
		try {
			vo = dao.updateIMGLink(mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	
	
	@Override
	public List<CharVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	   public int insertChar(CharVO vo) {
	      return dao.insertChar(vo);
	   }

	@Override
	public List<CharVO> isOn() {
		return dao.isOn();
	}

	@Override
	public int onChar(String memId) {
		return dao.onChar(memId);
	}

	@Override
	public int offChar(String memId) {
		return dao.offChar(memId);
	}

	@Override
	public int delChar(String mem_id) {
		return dao.delChar(mem_id);
	}

	@Override
	public CharVO selectchetChar(String nickName) {
		return dao.selectchetChar(nickName);
	}

	@Override
	public void allUp(String nick) {
		dao.allUp(nick);	
	}
	

}
