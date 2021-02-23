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
	// 댓글 저장하기

	// 댓글 수정하기

	// 댓글 삭제하기

	// 조회수 증가

	// 전체글 갯수 가져오기
	public int listCount();
}
