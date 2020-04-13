package _03单例模式.序列化破坏单例;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

    public static void main(String[] args) throws Exception{
        SerSingleton s1=null;
        SerSingleton s2=SerSingleton.getInstance();
        //对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerSingleton.obj"));
        //写出对象
        oos.writeObject(s2);
        //刷新流
        oos.flush();
        //释放资源
        oos.close();

        //对象输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SerSingleton.obj"));
        //读入对象
        s1= (SerSingleton) ois.readObject();
        //释放资源
        ois.close();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1==s2);
    }
}
