package com.alibaba.demo.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RequestLogFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLogFilter.class);
    // 过滤器类型

    /**
     * pre表示在请求前执行
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤器执行顺序，当一个请求在同一个阶段存在多个过滤器的时候，过个过滤器执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    // 判断过滤器是否生效
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 编写过滤器拦截业务逻辑代码
    @Override
    public Object run() throws ZuulException {
        // 1.获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 2.获取Request对象
        HttpServletRequest request = currentContext.getRequest();
        LOGGER.error("request:{}", request.getRequestURI());
        return null;
    }
}