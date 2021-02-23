package shop.dao;

import java.sql.SQLException;
import java.util.List;

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
			System.out.println("shopList : " + list);
		} catch (SQLException e) {
			list = null;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertItem(ShopVO vo) {
		int cnt = 0;
		try {
			cnt = (Integer)smc.insert("shop.insertShop",vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			cnt = 0;
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return cnt;
	}

	@Override
	public int deleteItem(int no) {
		// TODO Auto-generated method stub
		int cnt =0;
		try {
			cnt = smc.delete("shop.deleteShop", no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}




	

}
