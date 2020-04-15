package _05代理模式.静态代理.切换数据源例子;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        try{
            Order order = new Order();
            SimpleDateFormat format = new SimpleDateFormat("yyy/MM/dd");
            Date date = format.parse("2020/04/15");
            order.setCreateTime(date.getTime());

            IOrderService proxy = new OrderServiceStaticProxy(new OrderService());
            proxy.createOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
