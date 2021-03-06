package com.qihsoft.webdev.config.interceptor;

import com.qihsoft.webdev.utils.convert.J;
import com.qihsoft.webdev.utils.convert.V;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Qihsoft on 2017/10/13
 * 第一层数据拦截
 */
@Component
@Order(1)
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String token = request.getHeader("token");
        response.setHeader("Content-type", "text/html;charset=UTF-8");

        //处理404
        if (V.isEqual(request.getServletPath(), "/error")) {
            response.setStatus(404);
            response.getWriter().write(J.s2r("找不到对应的路由"));
            return false;
        }
        //token判断
        if (V.isEmpty(token)) {
            response.setStatus(411);
            response.getWriter().write(J.s2r("token 口令不能为空 !"));
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
