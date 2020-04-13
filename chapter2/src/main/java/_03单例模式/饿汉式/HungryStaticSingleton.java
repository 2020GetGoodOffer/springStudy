package _03单例模式.饿汉式;

public class HungryStaticSingleton {
    //私有唯一实例
    private static final HungryStaticSingleton hungryStaticSingleton;
    static {
        hungryStaticSingleton=new HungryStaticSingleton();
    }
    //私有构造方法
    private HungryStaticSingleton(){}
    //公有获取实例方法
    public static HungryStaticSingleton getInstance(){
        return hungryStaticSingleton;
    }
}
