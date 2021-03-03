package inventory.dao;

import java.sql.SQLException;
import java.util.List;

import vo.InventoryVO;
import vo.ShopVO;

public interface IInventoryDao {
	
	
	//인벤토리 추가
	public String insertInventory(InventoryVO vo) throws SQLException;
	
	//인벤의 no를 출력
	public List<InventoryVO> seletAll(String char_nickname) throws SQLException;

	//인벤의 no를 통해 shop의 link를 출력
	public List<ShopVO> selectIMG(String nickName) throws SQLException;
	
	
	
	
}
