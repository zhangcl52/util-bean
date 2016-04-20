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

    public POIReader(String path) {
        try {
            wb = WorkbookFactory.getInstance(path);
        } catch (TypeNotMatchException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ExcelSheet> readExcel(String filepath) {
        int sheetsCount = wb.getNumberOfSheets();
        List<ExcelSheet> excelSheetList= Lists.newArrayList();
        for (int i = 0; i < sheetsCount; i++) {
            Sheet sheet = wb.getSheetAt(i);
            ExcelSheet excelSheet = new ExcelSheet();
            excelSheet.setBeanName(sheet.getRow(0).getCell(0).getStringCellValue());
            List<ExcelRow> excelRows = Lists.newArrayList();
            int rowsCount = sheet.getPhysicalNumberOfRows();
            for (int j = 0; j < rowsCount; j++) {
                Row row = sheet.getRow(j);
                int rowCounts = row.getPhysicalNumberOfCells();
                ExcelRow excelRow=new ExcelRow();
                List<Cell> cellList=Lists.newArrayList();
                for (int k = 0; k < rowCounts; k++) {
                    Cell cell = new Cell();
                    cell.setColumn(k);
                    cell.setRow(j);
                    cell.setContents(row.getCell(k).getStringCellValue());
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

}
