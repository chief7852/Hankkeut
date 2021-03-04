package backmusic.service;

import java.util.List;

import backmusic.dao.BackmusicDaoImpl;
import backmusic.dao.IBackmusicDao;
import shop.service.ShopServiceImpl;
import vo.BackMusicVO;

public class BackmusicServiceImpl implements IBackmusicService {
	private static IBackmusicService service = null;
	
	private IBackmusicDao dao;
	public BackmusicServiceImpl() {
		dao = BackmusicDaoImpl.getDao();
	}
	
	public static IBackmusicService getService() {
		if(service == null) service = new BackmusicServiceImpl();
		return service;
	}
	
	
	@Override
	public List<BackMusicVO> selectAll() {
		
		return dao.selectAll();
	}


	
}
