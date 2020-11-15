package com.puppyloper.todo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandlerResolver implements HandlerExceptionResolver {
    private static final Log logger = LogFactory.getLog(MyExceptionHandlerResolver.class);

    public ModelAndView resolveException(HttpServletRequest request, 
        HttpServletResponse response, @Nullable Object handler, Exception ex) {
        logger.info("resolveException");
        ModelAndView mv = new ModelAndView();
        mv.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return mv;
    }
}
