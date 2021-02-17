package service;

import java.util.List;
import java.util.Map;

import vo.BoardVO;

public interface IBoardService {
	// �쟾泥� 由ъ뒪�듃 異쒕젰
	public List<BoardVO> selectAll();
	
	// �럹�씠吏�蹂� 紐⑸줉 媛��졇�삤湲�
	public List<BoardVO> selectByPage(Map<String, Integer> map);
	
	// 寃뚯떆湲� ���옣�븯湲�
	public int insertBoard(BoardVO vo);
	// 寃뚯떆湲� �닔�젙�븯湲�
	
	// 寃뚯떆湲� �궘�젣�븯湲�
	public int deleteBoard(int num);
	
	// �뙎湲� ���옣�븯湲�
	
	// �뙎湲� �닔�젙�븯湲�
	
	// �뙎湲� �궘�젣�븯湲�
	
	// 議고쉶�닔 利앷�
	
	// �쟾泥닿� 媛��닔 媛��졇�삤湲�
	public int listCount();
}
