package inventory.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.SqlMapClientFactory;
import vo.InventoryVO;
import vo.ShopVO;

public class InventoryDaoImpl implements IInventoryDao {

	private static IInventoryDao dao = null;
	private SqlMapClient smc;
	
	public InventoryDaoImpl() {
		smc = SqlMapClientFactory.getClient();
	}
	
	public static IInventoryDao getDao() {
		if(dao==null) dao = new InventoryDaoImpl();
		return dao;
	}

	@Override
	public List<InventoryVO> selectAll(){
		List<InventoryVO> inventoryList = null;
		
		try {
			inventoryList = smc.queryForList("inventory.selectAll");
		} catch (SQLException e) {
			inventoryList = null;
			e.printStackTrace();
		}
		return inventoryList;
	}
	
	


	
	
		
	
}
