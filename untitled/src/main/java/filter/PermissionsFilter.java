package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class PermissionsFilter implements Filter {
    public PermissionsFilter() {
        System.out.println("FirstFilter构造方法");
    }

    public void destroy() {
        System.out.println("FirstFilter.destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FirstFilter请求执行");
        chain.doFilter(req, resp);
        System.out.println("FirstFilter响应执行");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("FirstFilter.init");

    }

}
