package com.hunter.util;

import java.util.List;

import com.hunter.entity.ExcelSheet;

/**
 * @author Administrator 2016年4月15日上午8:58:07
 *
 * 
 */
public interface ReadExcel {
    public List<ExcelSheet> readExcel(String filepath);
}
