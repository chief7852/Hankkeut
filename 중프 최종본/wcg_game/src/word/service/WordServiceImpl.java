package word.service;

import java.util.List;
import java.util.Map;

import vo.WordVO;
import word.dao.IWordDao;
import word.dao.WordDaoImpl;

public class WordServiceImpl implements IWordService {
	// Service객체는 Dao객체를 사용하기 때문에
	// Dao객체가 저장될 변수가 필요하다.
	
	private IWordDao wordDao;
	private static WordServiceImpl service;
	
	//생성자
	private WordServiceImpl() {
//		memDao = new memberDaoImpl();		//오류 이유 : 싱글톤 패턴적용했기때문
		wordDao = WordDaoImpl.getInstance();
	}
	
	public static WordServiceImpl getInstance() {
		if(service == null){
			service = new WordServiceImpl();
		}
		return service;
	}
	
	@Override
	public int insertWord(WordVO memVo) {
		
		return wordDao.insertWord(memVo);
	}

	@Override
	public String selectWord(String word) {
		// TODO Auto-generated method stub
		return wordDao.selectWord(word);
	}

	@Override
	public String selectRand() {
		// TODO Auto-generated method stub
		return wordDao.selectRand();
	}

	
}
