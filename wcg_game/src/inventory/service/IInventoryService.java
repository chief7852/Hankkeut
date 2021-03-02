package inventory.service;

import java.sql.SQLException;
import java.util.List;

import vo.InventoryVO;

public interface IInventoryService {

	//아이템 리스트 출력
		public List<InventoryVO> selectAll();
}
	