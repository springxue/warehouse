package com.casic.warehouse.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
@Component
public class MyInterceptor implements HandlerInterceptor {  //实现原生拦截器的接口

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Object user=request.getSession().getAttribute("user");
        if(user==null){
            request.getSession().setAttribute("msg","请先登录！！");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        //进行逻辑判断，如果ok就返回true，不行就返回false，返回false就不会处理改请求
        return true;
    }
}

