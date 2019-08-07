package com.neuedu.exception;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class MyExceptionHandlerResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {


        System.out.println("============="+ex.getMessage());


        MyException myException=(MyException) ex;
        String error= myException.getDirector();

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("error");
        Map<String,Object> model= modelAndView.getModel();
        model.put("es","es1");



        return modelAndView;
    }
}
