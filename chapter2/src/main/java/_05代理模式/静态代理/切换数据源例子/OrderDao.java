package _05代理模式.静态代理.切换数据源例子;

public class OrderDao {

    public int insert(Order order){
        System.out.println("OrderDao创建Order成功");
        return 1;
    }
}
