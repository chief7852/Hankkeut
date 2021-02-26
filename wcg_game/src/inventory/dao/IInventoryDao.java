package inventory.dao;

import java.sql.SQLException;
import java.util.List;

import vo.InventoryVO;
import vo.ShopVO;

public interface IInventoryDao {
	
	//아이템 리스트 출력
	public List<InventoryVO> selectAll();
	
	
}
