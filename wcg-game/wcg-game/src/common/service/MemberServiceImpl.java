package common.service;

import java.sql.SQLException;

import common.dao.IMemberDao;
import common.dao.MemberDaoImpl;
import dao.BoardDaoImpl;
import dao.IBoardDao;
import vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private static IMemberService service = null;

	private IMemberDao dao;

	private MemberServiceImpl() {
		dao = MemberDaoImpl.getDao();
	}

	public static IMemberService getService() {
		if (service == null)
			service = new MemberServiceImpl();
		return service;
	}

	@Override
	public String insertMember(MemberVO vo) {
		String inputId = null;

		try {
			inputId = dao.insertMember(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return inputId;
	}

	@Override
	public int deleteMember(String mem_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
