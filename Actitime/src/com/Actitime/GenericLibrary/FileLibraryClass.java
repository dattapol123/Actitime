package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class is a generic class which contains non ststic method to read data from property file and excel file
 * @author Datta
 *
 */
public class FileLibraryClass {
	/**
	 * this method is a non static method used to read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDatafromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./TestData/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	/**
	 * this method is a non ststic method used to read data from excel file
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDatafromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestData/Bankinginfo.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

}
