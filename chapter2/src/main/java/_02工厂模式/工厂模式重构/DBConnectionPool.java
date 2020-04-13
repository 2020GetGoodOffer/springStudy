package _02工厂模式.工厂模式重构;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

//数据库连接池管理类
public class DBConnectionPool extends Pool {

    //正在使用的连接数
    private int checkOut;
    //存放产生的连接对象容器
    private Vector<Connection> freeConnections=new Vector<>();
    //数据库连接信息
    private String url;
    private String userName;
    private String passWord;
    //空闲连接数
    private static int num;
    //当前可用连接数
    private static int numActive=0;
    //连接池实例
    private static DBConnectionPool pool=null;

    //产生数据库连接池
    private DBConnectionPool(){
        try {
            init();
            for(int i=0;i<normalConnect;i++){
                Connection connection=newConnection();
                if(connection!=null){
                    freeConnections.addElement(connection);//往容器中添加连接对象
                    num++;//记录总连接数
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //获得一个数据库连接池实例
    public static synchronized DBConnectionPool getInstance(){
        if(pool==null)
            pool=new DBConnectionPool();
        return pool;
    }

    //初始化
    private void init() throws IOException{
        InputStream is = Pool.class.getResourceAsStream(propertiesName);
        Properties properties = new Properties();
        properties.load(is);
        this.userName=properties.getProperty("userName");
        this.passWord=properties.getProperty("passWord");
        this.driverName=properties.getProperty("driverName");
        this.url=properties.getProperty("url");
        this.maxConnect=Integer.parseInt(properties.getProperty("maxConnect"));
        this.normalConnect=Integer.parseInt(properties.getProperty("normalConnect"));
    }

    //如果不再使用某个连接对象，释放其到连接池
    public synchronized void freeConnection(Connection connection){
        freeConnections.addElement(connection);
        num++;
        checkOut--;
        numActive--;
        notifyAll();
    }

    //创建一个新连接
    private Connection newConnection(){
        Connection connection=null;
        try{
            if(userName==null)
                connection= DriverManager.getConnection(url);
            else
                connection=DriverManager.getConnection(url,userName,passWord);
            System.out.println("连接池创建一个新的连接");
        }catch (Exception e){
            System.out.println("无法创建这个url的连接"+url);
            return null;
        }
        return connection;
    }

    //返回空连接
    public int getNum(){
        return num;
    }

    //返回当前连接数
    public int getNumActive(){
        return numActive;
    }

    //单例模式获取可用连接
    public synchronized Connection getConnection(){
        Connection connection=null;
        if(freeConnections.size()>0){
            num--;
            connection=freeConnections.firstElement();
            freeConnections.remove(0);
            try{
                if(connection.isClosed()){
                    System.out.println("从连接池中删除一个无效连接");
                    connection=getConnection();
                }
            }catch (Exception e){
                System.out.println("从连接池中删除一个无效连接");
                connection=getConnection();
            }
        }else if(maxConnect==0||checkOut<maxConnect) {//没有空闲连接且当前连接小于最大允许值 最大值为0则不限制
            connection = newConnection();
        }
        if(connection!=null)
            checkOut++;
        numActive++;
        return connection;
    }

    //获取一个连接，加上等待时间限制，单位ms
    public synchronized Connection getConnection(long timeout){
        long startTime=new Date().getTime();
        Connection connection;
        while ((connection=getConnection())==null){
            try{
                wait(timeout);
            }catch (Exception ignored){}
            if(new Date().getTime()-startTime>=timeout)
                return null;
        }
        return connection;
    }

    //关闭所有连接
    public synchronized void release(){
        try{
            Enumeration<Connection> allConnections = freeConnections.elements();
            while (allConnections.hasMoreElements()){
                Connection connection=allConnections.nextElement();
                try{
                    connection.close();
                    num--;
                }catch (SQLException e){
                    System.out.println("无法关闭连接");
                }
            }
        }finally {
            super.release();
        }
    }

    //建立连接池
    public void createPool(){
        pool=new DBConnectionPool();
        if(pool!=null)
            System.out.println("连接池创建成功");
        else
            System.out.println("连接池创建失败");
    }
}
