package res.config;

import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	private static SqlMapClient smc;		// smc ����
	
	static{
		
		try {
			// 1-1. ���� ���ڵ� �ɸ��ͼ� ����
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			// 1-2. ȯ�� ���� ���� �о����
			Reader rd = Resources.getResourceAsReader("config/sqlMapConfig.xml");
			
			// 1-3. ������ �о�� Reader��ü�� �̿��Ͽ� ���� ȯ�� ������
			//		������ �� SQL���� ȣ���ؼ� ������ ��ü�� �����Ѵ�.
			
			 smc = SqlMapClientBuilder.buildSqlMapClient(rd); 		//smc ����
			// smc : �������� �о�� ������ ��ü
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public static SqlMapClient getClient(){
		return smc;
	}
}
