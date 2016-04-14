package com.hunter.entity;

/**
 * @author zhangcl 2016年4月14日 上午9:04:50
 *
 */
public class OracleColumnImpl implements DBColumnInte {
    // char类型
    private String oraChar;
    // Date/timestamp
    private String oraDate;
    // number(n)
    private String oraNumber1;
    // number(n,n)
    private String oraNumber2;

    public String getOraChar() {
	return oraChar;
    }

    public void setOraChar(String oraChar) {
	this.oraChar = oraChar;
    }

    public String getOraDate() {
	return oraDate;
    }

    public void setOraDate(String oraDate) {
	this.oraDate = oraDate;
    }

    public String getOraNumber1() {
	return oraNumber1;
    }

    public void setOraNumber1(String oraNumber1) {
	this.oraNumber1 = oraNumber1;
    }

    public String getOraNumber2() {
	return oraNumber2;
    }

    public void setOraNumber2(String oraNumber2) {
	this.oraNumber2 = oraNumber2;
    }
}
