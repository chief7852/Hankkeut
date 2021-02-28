package word.service;

import java.sql.SQLException;
import java.util.List;

import common.dao.IMemberDao;
import common.dao.MemberDaoImpl;
import vo.MemberVO;
import vo.noticeBoardVO;
import word.dao.IWordDao;
import word.dao.WordDaoImpl;

public class WordServiceImpl implements IWordService {
	private static IWordService service = null;

	private IWordDao dao;

	private WordServiceImpl() {
		dao = WordDaoImpl.getDao();
	}

	public static IWordService getService() {
		if (service == null)
			service = new WordServiceImpl();
		return service;
	}

	
	@Override
	public String selectWord(String word) {
		String result = null;
		
		try {
			result = dao.selectWord(word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}



}
