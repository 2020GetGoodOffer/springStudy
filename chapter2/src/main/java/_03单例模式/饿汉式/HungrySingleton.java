package _03单例模式.饿汉式;

public class HungrySingleton {
    //私有唯一实例
    private static final HungrySingleton hungrySingleton=new HungrySingleton();
    //私有构造方法
    private HungrySingleton(){}
    //公有获取实例方法
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
