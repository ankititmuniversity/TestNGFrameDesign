package utilities;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XcelUtility {

    public static FileInputStream fis = null;
    public static FileOutputStream fos = null;
    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static XSSFCellStyle cellStyle;

    public static int getRowCount(String path, String sheetName) throws IOException {
        fis = new FileInputStream(path);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        wb.close();
        fis.close();
        return rowCount;
    }

    public static int getColumnCount(String path, String sheetName, int rowNum) throws IOException {
        fis = new FileInputStream(path);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        int colCount = row.getLastCellNum();
        wb.close();
        fis.close();
        return colCount;
    }

    public static String getCellValue(String path, String sheetName, int rowNum, int colNum) throws IOException {
        fis = new FileInputStream(path);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        String cellValue;
        try {
            cellValue = cell.toString();
//            DataFormatter formatter = new DataFormatter();
//            cellValue = formatter.formatCellValue(cell);
        } catch (Exception e) {
            cellValue = "";
            e.printStackTrace();
        }
        wb.close();
        fis.close();
        return cellValue;
    }

    public static void setCellValue(String path, String sheetName, int rowNum, int colNum, String cellValue) throws IOException {
        fis = new FileInputStream(path);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNum);

        cell = row.createCell(colNum);
        cell.setCellValue(cellValue);
        fos = new FileOutputStream(path);
        wb.write(fos);
        wb.close();
        fis.close();
        fos.close();
    }

    public static void fillGreenColor(String path, String sheetName, int rowNum, int colNum) throws IOException {
        fis = new FileInputStream(path);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);

        cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);
        fos = new FileOutputStream(path);
        wb.write(fos);
        wb.close();
        fis.close();
        fos.close();
    }

    public static void fillRedColor(String path, String sheetName, int rowNum, int colNum) throws IOException {
        fis = new FileInputStream(path);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);

        cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);
        fos = new FileOutputStream(path);
        wb.write(fos);
        wb.close();
        fis.close();
        fos.close();
    }

}
