package com.neuedu.interceptors;

import com.neuedu.consts.Const;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import com.neuedu.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class AuthorityInterceptor implements HandlerInterceptor {


    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        UserInfo userInfo = (UserInfo) request.getSession().getAttribute(Const.CURRENT_USER);

        if(userInfo == null){
            String CookieUserName = null;
            String CookiePassword = null;

            Cookie[] cookies = request.getCookies();
            if(cookies==null) {
                response.sendRedirect(request.getContextPath()+"/user/login");
            }
                if(cookies!=null){
                for(Cookie cookie : cookies){
                    if("username".equals(cookie.getName())){
                        CookieUserName = cookie.getValue();
                    }else if("password".equals(cookie.getName())){
                        CookiePassword = cookie.getValue();
                    }
                    //}
                }
                if(CookieUserName!=null &&CookiePassword!=null){

                    UserInfo loginuserInfo=userService.findByUsername(CookieUserName);
                    if(CookiePassword.equals(loginuserInfo.getPassword())){
                        request.getSession().setAttribute(Const.CURRENT_USER, loginuserInfo);
                        //return true;

                    }else {
                        response.sendRedirect(request.getContextPath()+"/user/login");
                    }
                }else {
                    response.sendRedirect(request.getContextPath()+"/user/login");
                }
            }
        }
        return true;
       //false:拦截请求 true:不会拦截请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("=====postHandle======");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        System.out.println("=====afterCompletion======");
    }
}
