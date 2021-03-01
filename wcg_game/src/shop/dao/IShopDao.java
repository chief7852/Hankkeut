	package shop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.ShopVO;

public interface IShopDao {
	
		//전체목록 띄우기
		public List<ShopVO> selectAll();
		
		//아이템하나출력
		public ShopVO selectOne(int no);
		
		
	
}
