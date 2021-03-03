package character.dao;

import java.sql.SQLException;
import java.util.List;

import vo.CharVO;
import vo.MemberVO;
import vo.noticeBoardVO;

public interface ICharacterDao {
	
	//��� ���� ��ȸ
	public List<CharVO> selectAllChar() throws SQLException;
	//ĳ���� ������ �ҷ�����
	public CharVO selectChar(String mem_id) throws SQLException;
	//ĳ���ͻ���
	public int insertChar(CharVO vo) throws SQLException;
	//ĳ���ͻ���
	public int deleteChar(String nickname) throws SQLException;
	//���ӿ���
	public void oncheckChar(String nickname) throws SQLException;
	//���ӿ��� ����
	public void onoffChar(String nickname) throws SQLException;
	//����ġ ����
	public void expUpChar(String nickname) throws SQLException;	
	//����Ʈ ����
	public void pointUpChar(String nickname) throws SQLException;	
	

	
	//소켓용
	public CharVO selectchetChar(String nick) throws SQLException;
}
