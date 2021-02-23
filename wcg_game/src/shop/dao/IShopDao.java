package shop.dao;

import java.util.List;

import vo.ShopVO;

public interface IShopDao {
	
		//전체목록 띄우기
		public List<ShopVO> selectAll();
		
		//아이템 추가
		public int insertItem(ShopVO vo);
		 
		//아이템 삭제
		public int deleteItem(int no);
		
	
}
