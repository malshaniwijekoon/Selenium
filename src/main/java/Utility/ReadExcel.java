package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	 public static String readExcel(int row,int col, String fileName,String sheetName) throws IOException, InvalidFormatException{
		
		   
		 
		   File file =    new File(fileName);
		   FileInputStream inputStream = new FileInputStream(file);
		
		  
		  
		   org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(inputStream);
		   org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);
		   DataFormatter formatter = new DataFormatter();
		   return formatter.formatCellValue(sheet.getRow(row).getCell(col));
			 
		    
          
	 }

}