package board.service;

import java.util.List;
import java.util.Map;

import vo.CommentVO;
import vo.freeBoardVO;
import vo.noticeBoardVO;

public interface IFreeService {
	

	//�옄�쑀寃뚯떆�뙋 �쟾泥� 由ъ뒪�듃 
	public List<freeBoardVO> selectAll();
	
	// �옄�쑀寃뚯떆�뙋 �쟾泥� 由ъ뒪�듃 媛쒖닔
	public int selectAllCnt();
	
	// �옄�쑀寃뚯떆�뙋 �럹�씠吏� 泥섎━瑜� �쐞�븳 硫붿냼�뱶
	public List<freeBoardVO> selectByPage(Map<String, Integer> map);
	
	// �옄�쑀寃뚯떆�뙋議고쉶�닔 利앷�
	public int updateViews(int boardNum);
	
	// �옄�쑀寃뚯떆�뙋�빐�떦 寃뚯떆臾� �궡�슜
		public freeBoardVO selectBoard(int boardNum);
		
		
		// �옄�쑀寃뚯떆�뙋 �벑濡�
		public int insertBoard(freeBoardVO vo);
		// �옄�쑀寃뚯떆�뙋  �닔�젙
		public int updateBoard(freeBoardVO vo);
		// �옄�쑀寃뚯떆�뙋 �궘�젣
		public int deleteBoard(int boardNum);
		

		// �뙎湲� �벑濡�
		public int insertReply(CommentVO vo);
		// �뙎湲� 由ъ뒪�듃 
		public List<CommentVO> listReply(String board_no);
	
		// 댓글 수정하기
		public int updateReply(CommentVO vo);
	
	 	// 댓글 삭제하기
		 public int deleteReply(int renum);
	 
		
}
