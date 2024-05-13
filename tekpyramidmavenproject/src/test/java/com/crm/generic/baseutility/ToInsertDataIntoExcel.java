package com.crm.generic.baseutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToInsertDataIntoExcel {

	
		public void getDataIntoExcel(String sheet , int row , int celNo , String Data) throws EncryptedDocumentException, IOException {
			
			FileInputStream fis = new FileInputStream("‪C:\\Users\\AMAN RAJ\\Desktop\\Data\\Book1.xlsx");
			Workbook wb  = WorkbookFactory.create(fis);
			              wb.getSheet(sheet).getRow(row).createCell(celNo).setCellValue(Data);
			              
		  FileOutputStream fos = new FileOutputStream("‪C:\\Users\\AMAN RAJ\\Desktop\\Data\\Book1.xlsx");
		  wb.write(fos);
		  wb.close();
			
		}

	}


