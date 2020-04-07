package utils;

public class ExcelDataProvider {

	
	public static void main(String[] args) {
		
	Object data[][]=testData("C:\\Users\\SG0228076\\git\\SeleniumFramework\\SeleniumFramework\\excel\\data.xlsx","Sheet1");
	//	System.out.println(data[1][1]);
	}
	public static Object[][] testData(String excelPath,String sheetName)
	{

		Excelutils excel=new Excelutils(excelPath,sheetName);
		int rowCount=excel.getRowCount();
		int colCount=excel.getColCount();

		Object data[][]=new Object[rowCount-1][colCount];
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<colCount;j++)
			{

				String cellData=excel.getData(i, j);
				System.out.print(cellData);
				data[i-1][j]=cellData;

			}
		} return data;
	}
}