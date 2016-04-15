package com.hunter.util;

import java.util.List;

import com.hunter.entity.ExcelSheet;

/**
 * @author zhagcl 2016年4月14日 下午11:42:34
 */
public class ReadExcelTest {
    public static void main(String[] args) {
        String filePath = "E:\\excelDemo\\demo.xls";
        ReadExcel readExcelJXL = new ReadExcelJXL();
        List<ExcelSheet> sheets = readExcelJXL.readExcel(filePath);
        for (ExcelSheet sheet : sheets) {
            System.out.println(sheet.toString());
        }
    }
}
