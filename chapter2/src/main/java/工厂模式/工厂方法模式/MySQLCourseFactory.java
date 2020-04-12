package 工厂模式.工厂方法模式;

import 工厂模式.简单工厂模式.ICourse;
import 工厂模式.简单工厂模式.MySQLCourse;

public class MySQLCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new MySQLCourse();
    }
}
