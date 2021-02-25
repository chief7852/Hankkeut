package shop.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.ShopVO;

public interface IShopService {
	
	//전체목록출력
	public List<ShopVO> selectAll();
	
	//추가
	public int insertItem(ShopVO vo);
	 
	//삭제
	public int deleteItem(int no);
	
	//카테고리별 이미지 가져오기
	public List<ShopVO> selectCategoryImg(Map<String, Integer> map);
	
	
	

	
}
	