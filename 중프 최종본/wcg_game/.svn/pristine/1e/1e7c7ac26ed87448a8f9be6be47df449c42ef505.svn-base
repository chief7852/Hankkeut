package word.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.WordVO;


public class WordDaoImpl implements IWordDao{
	private SqlMapClient smc;
	private static WordDaoImpl dao;	// 1번
	
	private WordDaoImpl() {	// 2번
		smc = SqlMapClientFactory.getClient();
	}
	
	public static WordDaoImpl getInstance() { //3번
		if(dao == null)
		{
			dao = new WordDaoImpl();
		}
		return dao;
	}
	
	
	
	@Override
	public int insertWord(WordVO wordVo) {
		int cnt =0;
		try {
			Object obj = smc.insert("word.insertWord", wordVo);
			
			if(obj == null) cnt =1;
			
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String selectWord(String word) {
		String result = null;
		
		try {
			result=(String)smc.queryForObject("word.selectWord", word);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
		
		return result;
	}

	@Override
	public String selectRand() {
		String result = null;
		
		try {
			result=(String)smc.queryForObject("word.selectRand");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
		
		return result;
	}

	


}
