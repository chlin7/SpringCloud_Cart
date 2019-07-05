package com.gensoft.user.controller;

import com.gensoft.user.VO.ResultVO;
import com.gensoft.user.constants.CookieConstant;
import com.gensoft.user.constants.RedisConstant;
import com.gensoft.user.entity.UserInfo;
import com.gensoft.user.enums.ResultEnum;
import com.gensoft.user.enums.RoleEnum;
import com.gensoft.user.service.IUserService;
import com.gensoft.user.util.CookieUtil;
import com.gensoft.user.util.ResultVOUtil;
import com.netflix.client.http.HttpResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 10:35 2019/7/5
 */
@RestController
@RequestMapping("/login")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private StringRedisTemplate redisTemplate;

	@GetMapping("buyer")
	public ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response){
		//1.0 openid查询用户
		UserInfo userInfo = userService.findByOpenid(openid);
		if (userInfo == null){
			return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
		}

		//2.0 判断角色
		if (RoleEnum.BUYER.getCode() != userInfo.getRole()){
			return ResultVOUtil.error(ResultEnum.ROLE_FAIL);
		}

		//3.0cookie设置openid
		CookieUtil.setCookie(response,CookieConstant.OPENID,openid,CookieConstant.expire);

		return ResultVOUtil.success();
	}

	@GetMapping("saller")
	public ResultVO saller(@RequestParam("openid") String openid,
						   HttpServletResponse response, HttpServletRequest request){

		Cookie cookie = CookieUtil.getCookie(request,CookieConstant.TOKEN);
		if (cookie != null && !StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue())))){
			return ResultVOUtil.success();
		}
		//1.0 openid查询用户
		UserInfo userInfo = userService.findByOpenid(openid);
		if (userInfo == null){
			return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
		}

		//2.0 判断角色
		if (RoleEnum.SELLER.getCode() != userInfo.getRole()){
			return ResultVOUtil.error(ResultEnum.ROLE_FAIL);
		}

		//3.0存储到redis
		Integer expire = CookieConstant.expire;
		String token = UUID.randomUUID().toString();

		redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE,token),openid,expire,TimeUnit.SECONDS);

		//3.0cookie设置token
		CookieUtil.setCookie(response,CookieConstant.TOKEN,token,expire);

		return ResultVOUtil.success();
	}
}
