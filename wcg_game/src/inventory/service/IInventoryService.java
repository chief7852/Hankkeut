package inventory.service;

import java.sql.SQLException;
import java.util.List;

import vo.InventoryVO;

public interface IInventoryService {

	
	//인벤토리에 아이템 추가
	public String insertInventory(InventoryVO vo);
		
	//아이템 리스트 출력
	public List<InventoryVO> seletAll();
		
}
