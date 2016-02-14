package lml.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Auther: Lmlj
 * @Date: 2016/2/14.
 */
public class ResponseFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //TODO login
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession();
//        if (session.getAttribute("user") != null) {
//            filterChain.doFilter(servletRequest, servletResponse);
//            setResponseProxy(servletResponse);
//        } else {
//            response.sendRedirect("/index.jsp");
//        }

        filterChain.doFilter(servletRequest, servletResponse);
        setResponseProxy(servletResponse);
    }

    public void destroy() {

    }

    //设置相应代理
    public void setResponseProxy(ServletResponse servletResponse) {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET");
        response.setHeader("Access-Control-Allow-Credentials", "true");
    }
}
