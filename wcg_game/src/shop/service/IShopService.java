package shop.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.ShopVO;

public interface IShopService {
	
	//전체목록출력
	public List<ShopVO> selectAll();
	
	//아이템 하나 출력
	public ShopVO selectOne(int no);
	

	
}
	