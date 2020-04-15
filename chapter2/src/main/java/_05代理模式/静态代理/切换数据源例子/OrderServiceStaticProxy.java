package _05代理模式.静态代理.切换数据源例子;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat format=new SimpleDateFormat("yyyy");
    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService){
        this.orderService=orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        Long time = order.getCreateTime();
        int dbRouter = Integer.parseInt(format.format(new Date(time)));
        System.out.println("静待代理类自动分配到DB_"+dbRouter+"数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    public void before(){
        System.out.println("代理前");
    }

    public void after(){
        System.out.println("代理后");
    }

}
