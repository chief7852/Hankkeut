package word.controller;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import vo.WordVO;
import word.service.IWordService;
import word.service.WordServiceImpl;

public class exel {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("d:/d_other/끄투 단어 데이터베이스 - 복사본.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int rowIndex = 0;
		int columnIndex = 0;
		// 시트 수 (첫번째에만 존재하므로 0을 준다)
		// 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		XSSFSheet sheet = workbook.getSheetAt(0);
		int temp = 200000;
		// 행의 수
		int rows = sheet.getPhysicalNumberOfRows();
		for(rowIndex=1; rowIndex < rows; rowIndex++){
			//행을 읽는다
			XSSFRow row = sheet.getRow(rowIndex);
			if(row != null){
				// 셀의 수
				int cells = row.getPhysicalNumberOfCells();
				for(columnIndex=0; columnIndex <= cells; columnIndex++){
					// 셀값을 읽는다
					XSSFCell cell = sheet.getRow(rowIndex).getCell((short)columnIndex);
					String value ="";
					// 셀이 빈값일 경우를 위한 널체크 
					if(cell == null){
						continue;
					}else{
						// 타입별로 내용읽기
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_FORMULA:
							value=cell.getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							value=cell.getNumericCellValue()+"";
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value=cell.getStringCellValue()+"";
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							value=cell.getBooleanCellValue()+"";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value=cell.getErrorCellValue()+"";
							break;
						}
					}
					if(!value.equals(null)&&!value.equals("false")) 
					{System.out.print("각 셀 내용 :" + value);
					
					temp++;
					
					WordVO vo = new WordVO();
					vo.setInit(getInitialSound(value));
					vo.setNeutral(getInitialSound2(value));
					vo.setW_no(temp);
					vo.setWord(value);
					IWordService service = WordServiceImpl.getInstance();
					service.insertWord(vo);
					
					}
					
					
				}
			}
		}
		System.out.println(temp+"개 완료했습니다.");		
	}
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
	
	private static String getInitialSound2(String text) {
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
}
