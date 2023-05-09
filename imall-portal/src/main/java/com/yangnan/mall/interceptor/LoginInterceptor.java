package com.yangnan.mall.interceptor;

import com.yangnan.mall.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // /cart/getCartListPage
            String uri = request.getRequestURI();
            System.out.println("uri: " + uri);
            session.setAttribute("beforePath", uri);
            response.sendRedirect("/user/getLoginPage");
            return false;
        }

        return true;
    }
}