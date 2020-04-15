package _05代理模式.动态代理.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeipo implements InvocationHandler {

    //被代理的对象
    private Object target;

    public Object getInstance(Object target) throws Exception{
        this.target=target;
        Class<?> clazz=target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target, args);
        after();
        return obj;
    }

    private void before(){
        System.out.println("我是媒婆，开始帮助你物色对象");
    }

    private void after(){
        System.out.println("物色对象完毕");
    }
}
