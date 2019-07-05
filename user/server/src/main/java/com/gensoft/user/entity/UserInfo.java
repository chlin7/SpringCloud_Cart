package com.gensoft.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 10:30 2019/7/5
 */
@Data
@Entity
public class UserInfo {

	@Id
	private String id;

	private String username;

	private String password;

	private String openid;

	private Integer role;
}
