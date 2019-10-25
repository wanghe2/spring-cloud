package com.wang.filter;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
/**
 * zuul过滤器，这里模拟任何请求都得带个token，不然不让访问
 * @author wanghe
 *
 */
public class TokenFlilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		/**
		 * 判断要不要走这个过滤器,可以根据请求上下文动态判断
		 */
		RequestContext ctx = RequestContext.getCurrentContext();
		Enumeration<String> keys=ctx.keys();
		System.err.println("路由的key: "+keys.toString());
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.err.println("url:"+request.getRequestURI()+"  method:"+request.getMethod());
        String token = request.getParameter("token");// 获取请求的参数

        if (!StringUtils.isEmpty(token)) {
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
            return null;
        } else {
            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
            return null;
        }
	}

	/**
	 * filter类型 ，可以有 pre 、post 、error类型
	 * pre在请求被路由之前调用
	 * post 路由后调用
	 * error时错误处理
	 */
	@Override
	public String filterType() {
		System.err.println("filtertype");
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
