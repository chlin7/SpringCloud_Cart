package com.gensoft.apigateway.filter;

import com.gensoft.apigateway.constants.CookieConstant;
import com.gensoft.apigateway.constants.RedisConstant;
import com.gensoft.apigateway.utils.CookieUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @ desc：权限拦截 买家
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 14:13 2019/6/29
 */
@Component
public class BuyerFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return PRE_DECORATION_FILTER_ORDER -1;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext requestContext = RequestContext.getCurrentContext();

		HttpServletRequest httpServletRequest = requestContext.getRequest();

		String url = httpServletRequest.getRequestURI();
		if("/order/order/create".equals(url)){
			return true;
		}
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest httpServletRequest = requestContext.getRequest();

		/**
		 * /order/create 只能买家访问(cookie有openid)
		 */
		Cookie cookie = CookieUtil.getCookie(httpServletRequest,CookieConstant.OPENID);
		if (cookie == null || StringUtils.isEmpty(cookie.getValue())){
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
		}

		return null;
	}
}
