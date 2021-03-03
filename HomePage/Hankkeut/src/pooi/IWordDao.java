package pooi;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.WordVO;

/**
 * 실제 DB와 연결해서 SQl문을 수행하여 결과를 작성해서 Service에 전달하는 interface
 *  
 * 각각의 메서드 하나가 DB와 관련된 작업 1개를 수행하도록 작성한다.
 * @author PC-03
 *
 */
 	
 

public interface IWordDao {
	
	
	

	public int insertWord(WordVO wordVo);
	
	public String selectWord(String word);
	

}
