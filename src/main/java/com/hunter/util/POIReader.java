package com.hunter.util;

import com.google.common.collect.Lists;
import com.hunter.entity.Cell;
import com.hunter.entity.ExcelRow;
import com.hunter.entity.ExcelSheet;
import com.hunter.exception.TypeNotMatchException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * @author Administrator 2016年4月15日 上午9:01:32
 */
public class POIReader implements ExcelReader {
    private Workbook wb = null;

    public POIReader(String filepath) {
        init(filepath);
    }

    public POIReader() {

    }

    /**
     * 初始化Workbook
     *
     * @param filepath
     */
    private void init(String filepath) {
        try {
            wb = WorkbookFactory.getWorkbook(filepath);
        } catch (TypeNotMatchException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ExcelSheet> readExcel(String filepath) {
        if (this.wb == null) {
            init(filepath);
        }
        return readExcel();
    }

    /**
     * 读取excel
     * @return
     */
    public List<ExcelSheet> readExcel() {
        if (this.wb == null) {
            return null;
        }
        int sheetsCount = wb.getNumberOfSheets();
        List<ExcelSheet> excelSheetList = Lists.newArrayList();
        //循环sheet
        for (int i = 0; i < sheetsCount; i++) {
            Sheet sheet = wb.getSheetAt(i);
            ExcelSheet excelSheet = new ExcelSheet();
            excelSheet.setBeanName(sheet.getRow(0).getCell(0).getStringCellValue());
            List<ExcelRow> excelRows = Lists.newArrayList();
            int rowsCount = sheet.getPhysicalNumberOfRows();
            //循环行
            for (int j = 0; j < rowsCount; j++) {
                Row row = sheet.getRow(j);
                int rowCounts = row.getPhysicalNumberOfCells();
                ExcelRow excelRow = new ExcelRow();
                List<Cell> cellList = Lists.newArrayList();
                //循环列
                for (int k = 0; k < rowCounts; k++) {
                    Cell cell = new Cell();
                    cell.setColumn(k);
                    cell.setRow(j);
                    cell.setContents(getValueOfString(row.getCell(k)));
                    cellList.add(cell);
                }
                excelRow.setCells(cellList);
                excelRows.add(excelRow);
            }
            excelSheet.setRows(excelRows);
            excelSheetList.add(excelSheet);
        }
        return excelSheetList;
    }

    /**
     *  将excel中的各种类型的值转换为string类型
     * @param cell
     * @return String
     */
    public String getValueOfString(org.apache.poi.ss.usermodel.Cell cell){
        String value=null;
        if(cell.getCellType()==cell.CELL_TYPE_STRING){
            value=cell.getStringCellValue();
        }else if(cell.getCellType()==cell.CELL_TYPE_BLANK){
            value="";
        }else if(cell.getCellType()==cell.CELL_TYPE_BOOLEAN){
            value=cell.getBooleanCellValue()?"true":"false";
        }else if(cell.getCellType()==cell.CELL_TYPE_ERROR){
            value="error";
        }else if(cell.getCellType()==cell.CELL_TYPE_FORMULA){
            value=cell.getCellFormula();
        }else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
            value= cell.getNumericCellValue()+"";
        }
        return value;
    }
}
