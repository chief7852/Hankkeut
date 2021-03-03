package kr.or.ddit.mapper;


import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	private static SqlMapClient smc;		// smc 占쏙옙占쏙옙
	
	static{
		
		try {
			// 1-1. 占쏙옙占쏙옙 占쏙옙占쌘듸옙 占심몌옙占싶쇽옙 占쏙옙占쏙옙
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			// 1-2. 환占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占싻억옙占쏙옙占�
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			// 1-3. 占쏙옙占쏙옙占쏙옙 占싻억옙占� Reader占쏙옙체占쏙옙 占싱울옙占싹울옙 占쏙옙占쏙옙 환占쏙옙 占쏙옙占쏙옙占쏙옙
			//		占쏙옙占쏙옙占쏙옙 占쏙옙 SQL占쏙옙占쏙옙 호占쏙옙占쌔쇽옙 占쏙옙占쏙옙占쏙옙 占쏙옙체占쏙옙 占쏙옙占쏙옙占싼댐옙.
			
			 smc = SqlMapClientBuilder.buildSqlMapClient(rd); 		//smc 占쏙옙占쏙옙
			// smc : 占쏙옙占쏙옙占쏙옙占쏙옙 占싻억옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙체
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public static SqlMapClient getClient(){
		return smc;
	}
}
