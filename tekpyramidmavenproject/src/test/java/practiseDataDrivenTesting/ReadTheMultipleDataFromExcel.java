package practiseDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\AMAN RAJ\\Desktop\\Data\\testscriptdata.xlsx");
	    Workbook wb	=WorkbookFactory.create(fis);
	     Sheet  sh = wb.getSheet("Sheet1");
     	int  rowCount  = sh.getLastRowNum();
     	for(int i=1;i<=rowCount;i++) {
     		Row row=sh.getRow(i);
     	    String	data1=row.getCell(0).toString();
     	   String	data2=row.getCell(1).toString();
     	   System.out.println(data1+"\t"+data2);
     	}
     	wb.close();
	  
	}

}
