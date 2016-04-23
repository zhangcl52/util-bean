package com.hunter.util;

import java.util.List;

import com.hunter.entity.ExcelSheet;

/**
 * @author zhagcl 2016年4月14日 下午11:42:34
 */
public class ReadExcelTest {
    public static void main(String[] args) {
        String filePath = "E:\\excelDemo\\demo.xlsx";
//        JXLReader jxlReader = new JXLReader();
        POIReader poiReader=new POIReader(filePath);
        List<ExcelSheet> sheets = poiReader.readExcel(filePath);
            
        for (ExcelSheet sheet : sheets) {
            System.out.println(sheet.toString());
        }
    }
}
