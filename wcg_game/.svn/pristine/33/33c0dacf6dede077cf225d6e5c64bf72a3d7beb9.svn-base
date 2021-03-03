package character.service;

import java.sql.SQLException;
import java.util.List;

import vo.CharVO;
import vo.MemberVO;
import vo.noticeBoardVO;

public interface ICharacterService {

	// ��� ���� ��ȸ
	public List<CharVO> selectAllChar();

	// ĳ���� ������ �ҷ�����
	public CharVO selectChar(String mem_id);

	// ĳ���ͻ���
	public int insertChar(CharVO vo);

	// ĳ���ͻ���
	public int deleteChar(String nickname);

	// ���ӿ���
	public void onoffChar(String nickname);
	//���ӿ���
	public void oncheckChar(String nickname);	

	// ����ġ ����
	public void expUpChar(String nickname);

	// ����Ʈ ����
	public void pointUpChar(String nickname);
	
	
	
	// 소켓용
	public CharVO selectchetChar(String nick);
}
