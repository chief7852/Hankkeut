package manager.service;

import java.sql.SQLException;
import java.util.List;

import common.dao.IMemberDao;
import common.dao.MemberDaoImpl;
import manager.dao.IManagerDao;
import manager.dao.ManagerDaoImpl;
import vo.ManagerVO;
import vo.MemberVO;
import vo.noticeBoardVO;

public class ManagerServiceImpl implements IManagerService {
	private static IManagerService service = null;

	private IManagerDao dao;

	private ManagerServiceImpl() {
		dao = ManagerDaoImpl.getDao();
	}

	public static IManagerService getService() {
		if (service == null)
			service = new ManagerServiceImpl();
		return service;
	}

	@Override
	public String comparison(ManagerVO vo) {
		// TODO Auto-generated method stub
		return dao.comparison(vo);
	}

}
