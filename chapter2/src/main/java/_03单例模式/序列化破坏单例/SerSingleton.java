package _03单例模式.序列化破坏单例;

import java.io.Serializable;

public class SerSingleton implements Serializable {

    public final static SerSingleton SINGLETON=new SerSingleton();

    private SerSingleton(){}

    public static SerSingleton getInstance(){
        return SINGLETON;
    }

    private Object readResolve(){
        return SINGLETON;
    }
}
