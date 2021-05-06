package constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {


public HashMap<String, String> read() throws IOException{
	FileInputStream fi=new FileInputStream("E:\\WorkSpace\\MavenPOM\\XLDATA\\DATA.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	Sheet s=wb.getSheet("LOGIN DATA");
	int rowcount=s.getLastRowNum();
	
	HashMap<String, String> data=new HashMap<String,String>();
	for(int i=0;i<=rowcount;i++){
	String key=s.getRow(i).getCell(0).getStringCellValue();
	String value=s.getRow(i).getCell(1).getStringCellValue();
	data.put(key, value);
	}
	
	return data;
}
public HashMap<String, List<String>> read1() throws IOException{
	FileInputStream fi=new FileInputStream("E:\\WorkSpace\\MavenPOM\\XLDATA\\DATA.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	Sheet s=wb.getSheet("WebElement");
	int rowcount=s.getLastRowNum();
	
	HashMap<String, List<String>> data=new HashMap<String,List<String>>();
	for(int i=0;i<=rowcount;i++){
		String key=s.getRow(i).getCell(0).getStringCellValue();
		List<String> value=new ArrayList<String>();
		value.add(s.getRow(i).getCell(1).getStringCellValue());
		value.add(s.getRow(i).getCell(2).getStringCellValue());
		data.put(key, value);
	}
	return data;
}
}