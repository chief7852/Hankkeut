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
	public int deleteMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.deleteMember(vo);
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

	@Override
	public String loginMember(MemberVO vo) {
		String resId = null;
		
		try {
			resId = dao.loginMember(vo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resId;
	}

	@Override
	public MemberVO isMember(MemberVO vo) {
		return dao.isMember(vo);
	}

	@Override
	public int updatePass(MemberVO vo) {
		return dao.updatePass(vo);
	}

	@Override
	public String selectEmail(String memid) {
		
		return dao.selectEmail(memid);
	}

	@Override
	public int isPassWord(MemberVO vo) {
		return dao.isPassWord(vo);
	}

	@Override
	public int updatePW(MemberVO vo) {
		return dao.updatePW(vo);
	}

	@Override
	public int updateAddr(MemberVO vo) {
		return dao.updateAddr(vo);
	}

	@Override
	public int updateTel(MemberVO vo) {
		return dao.updateTel(vo);
	}

	@Override
	public List<MemberVO> guestList() {
		return dao.guestList();
	}

	@Override
	public List<MemberVO> memRemoveList() {
		
		return dao.memRemoveList();
	}



}
