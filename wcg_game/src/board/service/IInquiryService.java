package board.service;

import java.util.List;
import java.util.Map;

import vo.InquiryBoardVO;
import vo.MemberVO;
import vo.freeBoardVO;

public interface IInquiryService {
	//글 목록 
	public List<InquiryBoardVO> selectAll();
	
	//페이징
	public List<InquiryBoardVO> selectByPage(Map<String, Integer> map);
	
	//글 상세 
	
	public InquiryBoardVO selectBoard(int boardNum);
	//글 쓰기 
	
	public int insertBoard(InquiryBoardVO vo);
	
	//전체페이지개수
	public int selectAllCnt();
	

}
