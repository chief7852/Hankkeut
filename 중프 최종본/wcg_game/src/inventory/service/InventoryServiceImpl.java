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
	//get�ż���
	public static IInventoryService getService() {
		if(service == null) service = new InventoryServiceImpl();
		return service;
	}

	
	@Override
	public String insertInventory(InventoryVO vo) {
		
		String num = 
				
				"";
		
		try {
			num = dao.insertInventory(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return num;
	}
	
	
	@Override
	public List<InventoryVO> seletAll(String char_nickname) {
		List<InventoryVO> list = null;
		
		try {
			list =   dao.seletAll(char_nickname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	@Override
	public List<ShopVO> selectIMG(String nickName) {
		
		List<ShopVO> list = null;
		
		try {
			list = dao.selectIMG(nickName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	


	
	
	
}
