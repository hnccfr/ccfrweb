package com.hundsun.eclp.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumUsersType {
	BASE_DATA((short)0, "基础数据"), 
	DEVELOPMENT_LEVEL((short)1,"开发级"),
	APPLICATION_LEVEL((short)2, "应用级");

	private Short code;
	private String msg;

	private EnumUsersType(Short code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Short getCode() {
		return this.code;
	}

	public void setCode(Short code) {
		this.code = code;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static Map<String, String> toMap() {
		Map enumDataMap = new HashMap();
		for (EnumUsersType e : values()) {
			enumDataMap.put(e.getCode().toString(), e.getMsg());
		}
		return enumDataMap;
	}
}

/*
 * Location: E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name: com.hundsun.eclp.enums.EnumUsersType JD-Core Version: 0.6.0
 */