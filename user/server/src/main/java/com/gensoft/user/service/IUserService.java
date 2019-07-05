package com.gensoft.user.service;

import com.gensoft.user.entity.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 10:34 2019/7/5
 */
public interface IUserService {

	UserInfo findByOpenid(String openid);
}
