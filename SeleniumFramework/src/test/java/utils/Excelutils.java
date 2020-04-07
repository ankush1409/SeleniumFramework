package utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {
static	XSSFWorkbook wb;
static XSSFSheet sheet;
static Properties prop= new Properties();
static String PrjPath=System.getProperty("user.dir");


/*public static void main(String[] args) {
	getRowCount();
	getData();
	//flightSearchtest();
	// TODO Auto-generated method stub

}*/

public Excelutils(String excelPath,String sheetName)
{
	try {
		wb = new XSSFWorkbook(excelPath);
		sheet=wb.getSheet(sheetName);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


public static int getRowCount() {
		int rwcnt=0;
	try {
	
		rwcnt=sheet.getPhysicalNumberOfRows();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rwcnt;
}
	
	public static String getData(int rowNum, int colNum) {
		
		String cellData=null;
		try {
			
			cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return cellData;
}
	
	public static int getColCount() {
		int colCnt=0;
		
		try {
			colCnt=sheet.getRow(0).getPhysicalNumberOfCells();
			//System.out.println("Col count"+colcnt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colCnt;
		
	}
		
}
