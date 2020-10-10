package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class PermissionsFilter implements Filter {
    public PermissionsFilter() {
        System.out.println("PermissionFilter构造方法");
    }

    public void destroy() {
        System.out.println("PermissionFilter.destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        if (requestURI.startsWith("/index.jsp") || requestURI.startsWith("/LoginServlet")) {
            chain.doFilter(req, resp);
        } else {
            String success = (String) request.getSession().getAttribute("success");
            if ("已登录".equals(success)) {
                chain.doFilter(req, resp);
            } else {
                HttpServletResponse response = (HttpServletResponse) resp;
                resp.getWriter().write("你还没有登录,3秒后跳转到登录页面");
                response.setHeader("refresh", "3;index.jsp");
            }
        }
    }

    public void init(FilterConfig config) {
        System.out.println("PermissionFilter.init");
    }
}
