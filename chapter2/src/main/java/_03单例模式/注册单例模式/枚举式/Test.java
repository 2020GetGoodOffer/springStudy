package _03单例模式.注册单例模式.枚举式;

import _03单例模式.序列化破坏单例.SerSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Test {

//    public static void main(String[] args) {
//        try {
//            EnumSingleton singleton1;
//            EnumSingleton singleton2=EnumSingleton.getInstance();
//            singleton2.setData(new Object());
//            //对象输出流
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("EnumSingleton.obj"));
//            //写出对象
//            oos.writeObject(singleton2);
//            //刷新流
//            oos.flush();
//            //释放资源
//            oos.close();
//
//            //对象输入流
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("EnumSingleton.obj"));
//            //读入对象
//            singleton1= (EnumSingleton) ois.readObject();
//            //释放资源
//            ois.close();
//
//            System.out.println(singleton1.getData());
//            System.out.println(singleton2.getData());
//            System.out.println(singleton1.getData()==singleton2.getData());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz=EnumSingleton.class;
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        EnumSingleton singleton= (EnumSingleton) constructor.newInstance("Kobe",24);
    }
}
