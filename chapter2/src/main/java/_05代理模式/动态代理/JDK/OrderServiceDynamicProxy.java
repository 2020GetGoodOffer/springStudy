package _05代理模式.动态代理.JDK;

import _05代理模式.静态代理.切换数据源例子.DynamicDataSourceEntry;
import _05代理模式.静态代理.切换数据源例子.IOrderService;
import _05代理模式.静态代理.切换数据源例子.Order;
import _05代理模式.静态代理.切换数据源例子.OrderService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceDynamicProxy implements InvocationHandler {

    private SimpleDateFormat format=new SimpleDateFormat("yyyy");
    private Object target;

    public Object getInstance(Object target){
        this.target=target;
        Class<?> clazz=target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        before(args[0]);
        Object object=method.invoke(target,args);
        after();
        return object;
    }

    public void before(Object target) throws Exception {
        System.out.println("代理前");
        Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
        int dbRouter = Integer.parseInt(format.format(new Date(time)));
        System.out.println("静待代理类自动分配到DB_"+dbRouter+"数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
    }

    public void after(){
        System.out.println("代理后");
    }

    public static void main(String[] args) {
        try{
            Order order=new Order();
            SimpleDateFormat format = new SimpleDateFormat("yyy/MM/dd");
            Date date = format.parse("2020/04/15");
            order.setCreateTime(date.getTime());

            IOrderService orderService= (IOrderService) new OrderServiceDynamicProxy().getInstance(new OrderService());
            orderService.createOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
