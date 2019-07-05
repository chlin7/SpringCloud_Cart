package com.gensoft.user.repository;

import com.gensoft.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 10:33 2019/7/5
 */
public interface IUserInfoRepository extends JpaRepository<UserInfo,String> {
	UserInfo findByOpenid(String openid);
}
