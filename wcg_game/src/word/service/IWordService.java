package word.service;

import java.sql.SQLException;
import java.util.List;

import vo.MemberVO;
import vo.noticeBoardVO;

public interface IWordService {

	// 문자체크
	public String selectWord(String word);
}
