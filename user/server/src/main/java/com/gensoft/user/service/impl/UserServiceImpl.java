package com.gensoft.user.service.impl;

import com.gensoft.user.entity.UserInfo;
import com.gensoft.user.repository.IUserInfoRepository;
import com.gensoft.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 10:34 2019/7/5
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserInfoRepository userInfoRepository;

	@Override
	public UserInfo findByOpenid(String openid) {
		return userInfoRepository.findByOpenid(openid);
	}
}
