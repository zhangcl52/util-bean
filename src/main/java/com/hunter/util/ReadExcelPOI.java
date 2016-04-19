package com.hunter.util;

import com.hunter.entity.ExcelSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author Administrator 2016年4月15日 上午9:01:32
 */
public class ReadExcelPOI implements ReadExcel {

    /*
     * (non-Javadoc)
     * 
     * @see com.hunter.util.ReadExcel#readExcel(java.lang.String)
     */
    @Override
    public List<ExcelSheet> readExcel(String filepath) {
        HSSFWorkbook wb = null;
        POIFSFileSystem fs = null;
        //设置要读取的文件路径
        try {
            fs = new POIFSFileSystem(new FileInputStream("d:\\book1.xls"));
            //HSSFWorkbook相当于一个excel文件，HSSFWorkbook是解析excel2007之前的版本（xls）
            //之后版本使用XSSFWorkbook（xlsx）
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
