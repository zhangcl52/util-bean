package com.hunter.util;

import com.google.common.collect.Lists;
import com.hunter.entity.Cell;
import com.hunter.entity.ExcelRow;
import com.hunter.entity.ExcelSheet;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author zhangcl 2016年4月14日 下午11:20:10
 */
public class ReadExcelJXL implements ReadExcel {
    /**
     * 获取sheets 不支持2007
     *
     * @param filepath
     * @return zhangcl
     */
    public List<ExcelSheet> readExcel(String filepath) {
        List<ExcelSheet> excelSheets = Lists.newArrayList();
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(new File(filepath));
            // Sheet sheet = workbook.getSheet(0);
            Sheet[] sheets = workbook.getSheets();
            if (sheets == null) {
                return null;
            }
            for (int i = 0; i < sheets.length; i++) {
                ExcelSheet excelSheet = new ExcelSheet();
                // 得到第一行第一列的单元格
                excelSheet.setBeanName(sheets[i].getCell(0, 0).getContents());
                int rows = sheets[i].getRows();
                int columns = sheets[i].getColumns();
                // System.out.println(sheets.length + " " + rows + " " +
                // columns);
                List<ExcelRow> excelRows = Lists.newArrayList();
                for (int r = 0; r < rows; r++) {
                    ExcelRow excelRow = new ExcelRow();
                    List<Cell> cells = Lists.newArrayList();
                    for (int c = 0; c < columns; c++) {
                        Cell cell = new Cell();
                        cell.setColumn(c);
                        cell.setRow(r);
                        cell.setContents(sheets[i].getCell(c, r).getContents());
                        cells.add(cell);
                    }
                    excelRow.setCells(cells);
                    excelRows.add(excelRow);
                }
                excelSheet.setRows(excelRows);
                excelSheets.add(excelSheet);
                // System.out.println(excelSheet.toString());
            }

        } catch (BiffException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return excelSheets;
    }
}
