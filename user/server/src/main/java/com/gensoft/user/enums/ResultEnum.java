package com.gensoft.user.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    LOGIN_FAIL(1, "登录失败"),
	ROLE_FAIL(1, "角色权限有误"),
	;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
