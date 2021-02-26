package shop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.ShopVO;

public interface IShopDao {
	
		//전체목록 띄우기
		public List<ShopVO> selectAll();
		
		//아이템 구입
		public int BuyItem(int no) throws SQLException;
		
		
	
}
