package _03单例模式.注册单例模式.容器式;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {
    private ContainerSingleton(){}

    private static final Map<String,Object> ioc=new ConcurrentHashMap<>();

    public static Object getBean(String className){
        synchronized (ioc){
            if(!ioc.containsKey(className)){
                Object object=null;
                try{
                    object=Class.forName(className).getConstructor().newInstance();
                    ioc.put(className,object);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return object;
            }else
                return ioc.get(className);
        }
    }
}
