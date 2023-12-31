package keyWordDriverFramework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib {
	
	// it is use to store generic reusable method and all the generic reusable method are non static 
	
	public String readDateFromExcel(String excelpath,String sheetName,int rowCount,int cellCount) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelpath);
		  Workbook wb = WorkbookFactory.create(fis);
		   Sheet sheet = wb.getSheet(sheetName);
		   Row row = sheet.getRow(rowCount);
		   Cell cell = row.getCell(cellCount);
		 //  String data = cell.getStringCellValue();
		 //  return data;
		   String data=null;
		   if(cell.getCellType()==cell.getCellType().STRING)
		   {
			   data=cell.getStringCellValue();
		   }
		   else if (cell.getCellType()==cell.getCellType().NUMERIC)
		   {
			   data=cell.getStringCellValue().valueOf(cell.getNumericCellValue()); 
		   }
		   return data;
	}
	public void WriteDataToExcel(String excelpath,String sheetName,int rowCount,int cellCount,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelpath);
		  Workbook wb = WorkbookFactory.create(fis);
		   Sheet sheet = wb.getSheet(sheetName);
		   Row row = sheet.createRow(rowCount);
		   Cell cell = row.createCell(cellCount);
		   cell.setCellValue(data);
		   FileOutputStream fos = new FileOutputStream(excelpath);
		   wb.write(fos);
		
		
	}
	public int rowCount(String excelpath,String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelpath);
		  Workbook wb = WorkbookFactory.create(fis);
		   Sheet sheet = wb.getSheet(sheetName);
		   int rc = sheet.getLastRowNum();
		   return rc;
		
		
	}
	public String readDataFromProperty(String property,String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(property);
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
		
		
	}
	

}
