package com.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.base.BaseClass;

public class ExcelUtility extends BaseClass{

	public static FileInputStream fis;
	public static Workbook wb;
	public static Sheet sh;
	
	public static String getData(String filepath, String sheetname, int row, int col) {
		
		log.info("Reading Excel sheet==>> "+sheetname);
		try {
			fis = new FileInputStream(filepath);
			wb = WorkbookFactory.create(fis);
			sh = wb.getSheet(sheetname);
		} catch (Exception e) {
			log.error("failed to read Excel sheet==>>"+sheetname);
		}
		log.info("Read rows and columns===>>"+sh.getRow(row).getCell(col).getStringCellValue());
		return sh.getRow(row).getCell(col).getStringCellValue();
	}
}
