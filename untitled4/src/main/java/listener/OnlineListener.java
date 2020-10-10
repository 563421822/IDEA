package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public OnlineListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {

    }

    public void contextDestroyed(ServletContextEvent sce) {

    }


    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("来了一个客户");
        //获得全局对象中人数属性
        Object ob = se.getSession().getServletContext().getAttribute("count");
        int num;
        if (ob == null) {
//说明你是第一个访问本网站的人
            num = 1;
        } else {
            num = Integer.parseInt(ob.toString());
        }
        se.getSession().getServletContext().setAttribute("count", num);
        System.out.println("目前网站的在线人数:" + se.getSession().getServletContext().getAttribute("count"));
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("走了一个客户");
        Object ob = se.getSession().getServletContext().getAttribute("count");
        int num = Integer.parseInt(ob.toString()) - 1;
        se.getSession().getServletContext().setAttribute("count", num);
        System.out.println("目前网站在线人数:" + se.getSession().getServletContext().getAttribute("count"));
    }


    public void attributeAdded(HttpSessionBindingEvent sbe) {

    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {

    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {

    }
}
