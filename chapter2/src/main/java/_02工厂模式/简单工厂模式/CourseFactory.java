package _02工厂模式.简单工厂模式;

public class CourseFactory {

    public ICourse create(Class<? extends ICourse> clazz){
        try{
            if(clazz!=null){
                return clazz.getConstructor().newInstance();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
