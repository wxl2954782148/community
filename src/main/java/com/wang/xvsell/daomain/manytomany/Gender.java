package com.wang.xvsell.daomain.manytomany;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * 性别枚举类
 * @author Administrator
 *
 */
@AllArgsConstructor
@Getter
public enum Gender {
	
	MAIL("男性"),FMAIL("女性");
	private String value;

}
