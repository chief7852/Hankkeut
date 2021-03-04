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
	public String insertInventory(InventoryVO vo) throws SQLException {
		
		return (String)smc.insert("inventory.insertInventory",vo);
	}

	@Override
	public List<InventoryVO> seletAll(String char_nickname) throws SQLException {
		
		return smc.queryForList("inventory.selectAllItemInInventory",char_nickname);
	}

	@Override
	public List<ShopVO> selectIMG(String nickName) throws SQLException {
		return smc.queryForList("inventory.selectLink",nickName);
	}




	
	


	
	
		
	
}
