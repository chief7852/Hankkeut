package inventory.dao;

import java.sql.SQLException;
import java.util.List;

import vo.InventoryVO;
import vo.ShopVO;

public interface IInventoryDao {
	
	
	//인벤토리에 아이템 추가
	public String insertInventory(InventoryVO vo) throws SQLException;
	
	//아이템 리스트 출력
	public List<InventoryVO> seletAll();
	
	
}
