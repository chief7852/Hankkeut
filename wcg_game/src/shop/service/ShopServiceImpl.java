package shop.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import shop.dao.IShopDao;
import shop.dao.ShopDaoImpl;
import vo.ShopVO;

public class ShopServiceImpl implements IShopService {
	private static IShopService service = null;
	
	private IShopDao dao;
	private ShopServiceImpl() {
		dao = ShopDaoImpl.getDao();
	}
	
	public static IShopService getService() {
		if(service == null) service = new ShopServiceImpl();
		return service;
	}
	
	@Override
	public List<ShopVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public int insertItem(ShopVO vo) {
		return dao.insertItem(vo);
	}

	@Override
	public int deleteItem(int no) {
		// TODO Auto-generated method stub
		return dao.deleteItem(no);
	}


	

	
	

}
