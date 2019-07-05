package com.gensoft.user.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 10:51 2019/7/5
 */
public class CookieUtil {

	public static void setCookie(HttpServletResponse response,String name,
								 String value,int maxAge){
		Cookie cookie = new Cookie(name,value);
		cookie.setPath("/");
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

	public static Cookie getCookie(HttpServletRequest request,String name){
		Cookie[] cookies = request.getCookies();
		if (cookies != null && name != null){
			for (Cookie cookie :cookies){
				if (name.equals(cookie.getName())){
					return cookie;
				}
			}
		}
		return null;
	}


}
