package word.dao;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;

import vo.MemberVO;
import vo.noticeBoardVO;

public class WordDaoImpl implements IWordDao {
	
	private SqlMapClient client;
	private static IWordDao dao;
	
	private WordDaoImpl () {
		client = SqlMapClientFactory.getClient();
	}
	public static IWordDao getDao() {
		if(dao == null) dao = new WordDaoImpl();
		return dao;
	}
	
	
	@Override
	public String selectWord(String word) throws SQLException {
		return (String) client.queryForObject("word.selectWord",word);
	}
	


}
