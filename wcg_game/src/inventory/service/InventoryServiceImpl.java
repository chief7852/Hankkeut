package inventory.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import inventory.dao.IInventoryDao;
import inventory.dao.InventoryDaoImpl;
import vo.InventoryVO;
import vo.ShopVO;

public class InventoryServiceImpl implements IInventoryService {
	
	private static IInventoryService service = null;
	
	private IInventoryDao  dao;
	public InventoryServiceImpl() {
		dao = InventoryDaoImpl.getDao();
	}
	//get매서드
	public static IInventoryService getService() {
		if(service == null) service = new InventoryServiceImpl();
		return service;
	}

	@Override
	public List<InventoryVO> selectAll() {
		return dao.selectAll();
	}


	
	
	
}
