package common.service;

import java.sql.SQLException;
import java.util.List;

import common.dao.IMemberDao;
import common.dao.MemberDaoImpl;
import vo.MemberVO;
import vo.noticeBoardVO;

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

	// 아이디 만들기
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

	//회원 탈퇴
	@Override
	public int deleteMember(String mem_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 아이디 체크
	@Override
	public String selectById(String mem_id) {
		String resId = null;
		
		try {
			resId = dao.selectById(mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resId;
	}



}
