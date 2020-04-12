package 工厂模式.工厂模式重构;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

public abstract class Pool {

    public String propertiesName="connection-INF.properties";
    //定义唯一实例
    private static Pool instance=null;
    //最大连接数
    protected int maxConnect=100;
    //保持连接数
    protected int normalConnect=10;
    //驱动字符串
    protected String driverName=null;
    //驱动变量
    protected Driver driver=null;

    //私有构造方法 不允许外部访问
    protected Pool(){
        try{
            init();
            loadDrivers(driverName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //初始化配置
    private void init() throws IOException {
        InputStream is = Pool.class.getResourceAsStream(propertiesName);
        Properties properties = new Properties();
        properties.load(is);
        this.driverName=properties.getProperty("driverName");
        this.maxConnect=Integer.parseInt(properties.getProperty("maxConnect"));
        this.normalConnect=Integer.parseInt(properties.getProperty("normalConnect"));
    }

    //装载和注册所有JDBC驱动程序
    private void loadDrivers(String driverName){
        try{
            driver= (Driver) Class.forName(driverName).getConstructor().newInstance();
            DriverManager.registerDriver(driver);
            System.out.println("成功注册JDBC驱动程序"+ driverName);
        }catch (Exception e){
            System.out.println("无法注册JDBC驱动程序"+ driverName +",错误："+e);
        }
    }

    //创建连接池
    public abstract void createPool();

    //单例模式返回数据库连接池实例
    public static synchronized Pool getInstance() throws Exception{
        if(instance!=null)
            instance= (Pool) Class.forName("org.jdbc.sqlhelper.Pool").getConstructor().newInstance();
        return instance;
    }

    //获得一个可用连接，如果没有则创建，且小于最大连接限制
    public abstract Connection getConnection();

    //获得一个连接，有时间限制
    public abstract Connection getConnection(long time);

    //将连接对象返回给连接池
    public abstract void freeConnection(Connection connection);

    //返回当前空闲连接数
    public abstract int getNum();

    //返回当前工作连接数
    public abstract int getNumActive();

    //撤销驱动
    protected synchronized void release(){
        try{
            DriverManager.deregisterDriver(driver);
            System.out.println("撤销JDBC驱动"+driver.getClass().getName());
        }catch (Exception e){
            System.out.println("无法撤销JDBC驱动"+driver.getClass().getName());
        }
    }
}
