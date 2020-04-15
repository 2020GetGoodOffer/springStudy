package _05代理模式.静态代理.切换数据源例子;

public class OrderService implements IOrderService {

    private OrderDao orderDao;

    public OrderService(){
        //如果使用Spring应该是自动注入的 模拟该过程直接初始化
        orderDao=new OrderDao();
    }
    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用orderDao创建订单");
        return orderDao.insert(order);
    }
}
