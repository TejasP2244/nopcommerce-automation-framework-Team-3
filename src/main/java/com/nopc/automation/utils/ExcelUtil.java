package com.nopc.automation.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {
    public static Object[][] getData(String filePath, String sheetName) throws IOException {
        Object[][] data=null;
        try{
            FileInputStream fis=new FileInputStream(filePath);
            Workbook workbook=new XSSFWorkbook(fis);
            Sheet sheet= workbook.getSheet(sheetName);
            int rows=sheet.getPhysicalNumberOfRows();
            int cols=sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rows-1][cols];// not counting the header row
            for(int i=1;i<rows;i+=1){
                Row row=sheet.getRow(i);
                for(int j=0;j<cols;j+=1){
                    Cell cell=row.getCell(j);
                    data[i-1][j]=cell==null?"":cell.toString();
                }
            }
        }catch(Exception e){
            throw new RuntimeException("Failed to read excel file", e);
        }
        return data;
    }
}
