package com.hunter.entity;

/**
 * 
 * @author Administrator
 *
 */
public class EastWind {
    // 数据库类型
    private String dbName;
    // bean的后缀
    private String beanSuf;
    // 需要实现的类
    private String impClassNames;
    // 源文件所在路径
    private String sourceFilePath;
    // 生成后文件存放路径
    private String storeFilePath;
    // 生成文件的类型 1：实体类 （*entity）, 2：映射文件（*.hbm.xml）,3:两者都生成
    private int fileType;
    // 数据库表名分隔符
    private String tableNameSplitSign;

    public String getDbName() {
	return dbName;
    }

    public void setDbName(String dbName) {
	this.dbName = dbName;
    }

    public String getBeanSuf() {
	return beanSuf;
    }

    public void setBeanSuf(String beanSuf) {
	this.beanSuf = beanSuf;
    }

    public String getImpClassNames() {
	return impClassNames;
    }

    public void setImpClassNames(String impClassNames) {
	this.impClassNames = impClassNames;
    }

    public String getSourceFilePath() {
	return sourceFilePath;
    }

    public void setSourceFilePath(String sourceFilePath) {
	this.sourceFilePath = sourceFilePath;
    }

    public String getStoreFilePath() {
	return storeFilePath;
    }

    public void setStoreFilePath(String storeFilePath) {
	this.storeFilePath = storeFilePath;
    }

    public int getFileType() {
	return fileType;
    }

    public void setFileType(int fileType) {
	this.fileType = fileType;
    }

    public String getTableNameSplitSign() {
	return tableNameSplitSign;
    }

    public void setTableNameSplitSign(String tableNameSplitSign) {
	this.tableNameSplitSign = tableNameSplitSign;
    }

}
