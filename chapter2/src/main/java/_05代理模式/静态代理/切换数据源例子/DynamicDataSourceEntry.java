package _05代理模式.静态代理.切换数据源例子;

//动态切换数据源
public class DynamicDataSourceEntry {

    //默认数据源
    public final static String DEFAULT_SOURCE=null;

    private final static ThreadLocal<String> local=new ThreadLocal<>();

    private DynamicDataSourceEntry(){}

    //清空数据源
    public static void clear(){
        local.remove();
    }

    //获取当前数据源名字
    public static String get(){
        return local.get();
    }

    //还原当前切换的数据源
    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }

    //设置数据源
    public static void set(String source){
        local.set(source);
    }

    //根据年份动态设置数据源
    public static void set(int year){
        local.set("DB_"+year);
    }
}
