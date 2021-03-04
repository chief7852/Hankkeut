package pooi;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.WordVO;



/**
 * Dao에 작성된 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고
 * 받아온 결과를 Controller에게 보내주는 역할을 수행한다.
 * 
 * 보통 Dao의 메서드와 같게만든다
 * @author PC-03
 *
 */
public interface IWordService {
	
 
	public int insertWord(WordVO wordVo);
	
	
	public String selectWord(String word);
}
