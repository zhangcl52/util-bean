package com.hunter.entity;

import java.util.List;

/**
 * @author zhangcl 2016年4月14日 下午11:57:19
 *
 * 
 */
public class ExcelSheet {
    private String beanName;
    private List<ExcelRow> rows;

    public String getBeanName() {
	return beanName;
    }

    public void setBeanName(String beanName) {
	this.beanName = beanName;
    }

    public List<ExcelRow> getRows() {
	return rows;
    }

    public void setRows(List<ExcelRow> rows) {
	this.rows = rows;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder("");
	for (ExcelRow row : rows) {
	    sb.append(row.toString()).append("\n");
	}
	return sb.toString();
    }
}
