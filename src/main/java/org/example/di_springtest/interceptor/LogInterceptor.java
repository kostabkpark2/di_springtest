package org.example.di_springtest.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String requestURI = request.getRequestURI();
    if (handler instanceof HandlerMethod) {
      Method method = ((HandlerMethod) handler).getMethod();
      log.info(" !!!!!!!! (prehandler) Request URI and Handler ==> {}, {} ", requestURI, method.getDeclaringClass().getSimpleName() + "." + method.getName());
    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    String requestURI = request.getRequestURI();
    if (handler instanceof HandlerMethod) {
      Method method = ((HandlerMethod) handler).getMethod();
      log.info(" !!!!!!!! (postHandler) Request URI and Handler ==> {}, {} ", requestURI, method.getDeclaringClass().getSimpleName() + "." + method.getName());
      log.info(" !!!!!!!! (postHandler) ModelAndView ==> {} , {}", modelAndView.getModel(), modelAndView.getViewName());

    }
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    String requestURI = request.getRequestURI();
    if (handler instanceof HandlerMethod) {
      Method method = ((HandlerMethod) handler).getMethod();
      log.info(" !!!!!!!! (afterCompletion) Request URI and Handler ==> {}, {} ", requestURI, method.getDeclaringClass().getSimpleName() + "." + method.getName());
      if(ex != null) {
        log.info(" !!!!!!!! (afterCompletion) Exception ==> {} ", ex.getMessage());
      }
    }
  }
}
