package com.hunter.util;

import com.google.common.base.Strings;
import com.hunter.exception.TypeNotMatchException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

/**
 * Created by zhangcl on 2016/4/19.
 */
public class WorkbookFactory {
    private static Workbook wb = null;
    private static String XLS = "xls";
    private static String XLSX = "xlsx";

    private WorkbookFactory() {
    }

    /**
     * 以xls结尾的文件用的是HSSFWorkbook类读取
     * 以xlsx结尾的文件用的是XSSFWorkbook类读取
     * @param filePath
     * @return
     * @throws Exception
     */
    public static Workbook getWorkbook(String filePath) throws Exception {
        if (Strings.isNullOrEmpty(filePath)) {
            return null;
        }
        if (!filePath.endsWith(XLS) && !filePath.endsWith(XLSX)) {
            throw new TypeNotMatchException("文件类型只能是.xlx或.xlsx");
        }
        //HSSFWorkbook相当于一个excel文件，HSSFWorkbook是解析excel2007之前的版本（xls）
        //之后版本使用XSSFWorkbook（xlsx）
        if (filePath.endsWith(XLS)) {
            wb = new HSSFWorkbook(new FileInputStream(filePath));
        } else if (filePath.endsWith(XLSX)) {
            wb = new XSSFWorkbook(new FileInputStream(filePath));
        }
        return wb;
    }

}
