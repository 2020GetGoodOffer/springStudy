package _03单例模式.懒汉式;

import java.lang.reflect.Constructor;

public class LazyInnerClassSingleton {
    //使用时默认初始化内部类，没有使用则不加载
    private LazyInnerClassSingleton(){
        if(LazyHolder.LAZY!=null)
            throw new RuntimeException("不允许创建多个实例！");
    };

    public static LazyInnerClassSingleton getInstance(){
        //在返回结果前会先加载内部类
        return LazyHolder.LAZY;
    }

    //默认不加载
    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY=new LazyInnerClassSingleton();
    }

}

class Test{
    public static void main(String[] args) {
        LazyInnerClassSingleton.getInstance();
        LazyInnerClassSingleton.getInstance();
    }
}