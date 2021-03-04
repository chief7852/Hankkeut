package pooi;

import java.util.Scanner;

public class temp {
	private static char endpoint= '\u0000';
	private static String getInitialSound(String text) {
		String[] chs = { 
				"ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ", "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ"
		};
		
		if(text.length() > 0) {
			char chName = text.charAt(0);
			if(chName >= 0xAC00)
			{
				int uniVal = chName - 0xAC00;
				int cho = ((uniVal - (uniVal % 28))/28)%21;
				
				return chs[cho];
			}
		}
		
		return null; 
	}
	
	/*
	 private static String getInitialSound(String text) {
		String[] chs = { 
				"ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", 
				"ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", 
				"ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", 
				"ㅋ", "ㅌ", "ㅍ", "ㅎ" 
		};
		
		if(text.length() > 0) {
			char chName = text.charAt(0);
			if(chName >= 0xAC00)
			{
				int uniVal = chName - 0xAC00;
				int cho = ((uniVal - (uniVal % 28))/28)/21;
				
				return chs[cho];
			}
		}
		
		return null; 
	}
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String text = sc.nextLine();
		IWordService service = WordServiceImpl.getInstance();
		String result =service.selectWord(text);
		endpoint = text.charAt(text.length()-1);
		System.out.println(endpoint);
		if(result.length()>0)
		{
			System.out.println("존재한다.");
		}else {
			System.out.println("존재하지않는다.");
		}
		
		System.out.println(getInitialSound(text));
		
	}
	
}
