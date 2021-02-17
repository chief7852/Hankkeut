package service;

import dao.BoardDaoImpl;
import dao.IBoardDao;
import dao.IMemberDao;
import dao.MemberDaoImpl;
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
	public int insertMember(MemberVO vo) {
		
		return dao.insertMember(vo);
	}

	@Override
	public int deleteMember(String mem_id) {

		return dao.deleteMember(mem_id);
	}

}
