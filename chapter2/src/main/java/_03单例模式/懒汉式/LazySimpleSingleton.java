package _03单例模式.懒汉式;

public class LazySimpleSingleton {

    //私有构造方法
    private LazySimpleSingleton(){};
    //私有唯一实例
    private static LazySimpleSingleton singleton=null;
    //公有获取实例方法

    public static LazySimpleSingleton getSingleton() {
        if(singleton==null) {
            synchronized (LazySimpleSingleton.class) {
                if(singleton==null)
                    singleton = new LazySimpleSingleton();
            }
        }
        return singleton;
    }
}
