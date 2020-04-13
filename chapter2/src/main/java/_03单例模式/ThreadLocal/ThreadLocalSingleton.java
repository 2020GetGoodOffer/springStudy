package _03单例模式.ThreadLocal;

import _03单例模式.懒汉式.ExecutorThread;

public class ThreadLocalSingleton {

    //唯一实例对象
    private static final ThreadLocal<ThreadLocalSingleton> INSTANCE= ThreadLocal.withInitial(ThreadLocalSingleton::new);

    //私有构造方法
    private ThreadLocalSingleton(){}

    //公有获取方法
    public static ThreadLocalSingleton getInstance(){
        return INSTANCE.get();
    }

    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        new Thread(new TLThread()).start();
        new Thread(new TLThread()).start();

    }
}

class TLThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":"+ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName()+":"+ThreadLocalSingleton.getInstance());
    }
}