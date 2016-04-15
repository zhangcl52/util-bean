
package com.hunter.entity;

/**
 * @author zhangcl 2016年4月14日 上午21:44:00
 */
public class MySqlColumnImpl implements DBColumnInte {
    // int,tinyint,mediumint,int/integer,bigint
    private String mysInt;
    // float
    private String mysFloat;
    // double,decimal
    private String mysDouble;
    // char,varchar,tinyblob,tinytext,blob,text,mediumblob,
    // mediumtext,longblob,longtext,binary,varbinary
    private String mysChar;
    // date,time,datetime,timestamp
    private String myDate;

    public String getMysInt() {
        return mysInt;
    }

    public void setMysInt(String mysInt) {
        this.mysInt = mysInt;
    }

    public String getMysFloat() {
        return mysFloat;
    }

    public void setMysFloat(String mysFloat) {
        this.mysFloat = mysFloat;
    }

    public String getMysDouble() {
        return mysDouble;
    }

    public void setMysDouble(String mysDouble) {
        this.mysDouble = mysDouble;
    }

    public String getMysChar() {
        return mysChar;
    }

    public void setMysChar(String mysChar) {
        this.mysChar = mysChar;
    }

    public String getMyDate() {
        return myDate;
    }

    public void setMyDate(String myDate) {
        this.myDate = myDate;
    }

}
