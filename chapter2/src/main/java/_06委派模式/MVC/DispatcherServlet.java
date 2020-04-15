package _06委派模式.MVC;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//相当于项目经理的角色
public class DispatcherServlet extends HttpServlet {

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String uri=request.getRequestURI();
        System.out.println("uri: "+uri);
        String mid=request.getParameter("mid");
        System.out.println("mid: "+mid);


        if("/getMemberById".equals(uri)) {
            System.out.println("通过mid获取成员");
            new MemberController().getMemberById(mid);
        }
        else if("/getOrderById".equals(uri))
            new OrderController().getOrderById(mid);
        else if("/logout".equals(uri))
            new SystemController().logout();
        else
            response.getWriter().write("404 NOT FOUND!");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        try{
            doDispatch(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
