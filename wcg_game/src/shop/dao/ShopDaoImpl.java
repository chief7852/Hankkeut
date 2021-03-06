package shop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.ShopVO;

public class ShopDaoImpl implements IShopDao {

	private static IShopDao dao = null;
	private SqlMapClient smc;
	
	public ShopDaoImpl() {
		smc = SqlMapClientFactory.getClient();
	}
	
	public static IShopDao getDao() {
		if(dao == null) dao = new ShopDaoImpl();
		return dao;
	}
	
	@Override
	public List<ShopVO> selectAll() {
		List<ShopVO> list = null;
		try {
			list = smc.queryForList("shop.selectAll");
		} catch (SQLException e) {
			list = null;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}





	@Override
	public ShopVO selectOne(int no) {
		
		ShopVO vo= null;
		
		try {
			vo = (ShopVO) smc.queryForObject("shop.selectOne",no);
		} catch (SQLException e) {
			vo = null;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}






	
	


	
}	
