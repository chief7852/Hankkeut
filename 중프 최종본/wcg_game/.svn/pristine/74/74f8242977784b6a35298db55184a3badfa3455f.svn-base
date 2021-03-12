package character.service;

import java.sql.SQLException;
import java.util.List;

import character.dao.CharacterDaoImpl;
import character.dao.ICharacterDao;
import common.dao.IMemberDao;
import common.dao.MemberDaoImpl;
import vo.CharVO;
import vo.MemberVO;
import vo.noticeBoardVO;

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
	public List<CharVO> selectAllChar() {
		// TODO Auto-generated method stub
		return null;
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
	public int insertChar(CharVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteChar(String nickname) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void onoffChar(String nickname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void expUpChar(String nickname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pointUpChar(String nickname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void oncheckChar(String nickname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CharVO selectchetChar(String nick) {
		CharVO vo = new CharVO();
		try {
			vo = dao.selectchetChar(nick);

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	

}
