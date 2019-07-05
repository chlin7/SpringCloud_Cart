package com.gensoft.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @ desc：token过滤器
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 14:13 2019/6/29
 */
@Component
public class TokenFilter extends ZuulFilter {

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
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();

		HttpServletRequest httpServletRequest = requestContext.getRequest();
		//从request获取token 当前从参数获取，也可以从cookie、header等
		String token = httpServletRequest.getParameter("token");

		if (StringUtils.isEmpty(token)){
//			requestContext.setSendZuulResponse(false);
//			requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
		}

		return null;
	}
}
