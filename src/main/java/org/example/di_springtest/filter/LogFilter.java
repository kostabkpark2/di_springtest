package org.example.di_springtest.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest,
                       ServletResponse servletResponse,
                       FilterChain filterChain) throws IOException, ServletException {
    // 사용자의 모든 요청을 로그로 남겨보기 (어떤 URL 로 들어온 요청인지, 어떤 핸들러가 요청을 처리하고 있는지)
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    String requestURI = req.getRequestURI();
    log.info("Request URI ==> {} ", requestURI);
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
