package _03单例模式.懒汉式;

public class ExecutorThread implements Runnable {
    @Override
    public void run() {
        LazySimpleSingleton simpleSingleton=LazySimpleSingleton.getSingleton();
        System.out.println(Thread.currentThread().getName()+" "+simpleSingleton);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ExecutorThread());
        Thread t2 = new Thread(new ExecutorThread());
        t1.start();
        t2.start();
    }
}
