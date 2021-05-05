package constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
public static String uname,pword,browser,url;

public void read() throws IOException{
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
	uname=data.get("username");
	pword=data.get("password");
	browser=data.get("browser");
	url=data.get("url");
}
}