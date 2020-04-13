package _02工厂模式.工厂方法模式;

import _02工厂模式.简单工厂模式.ICourse;
import _02工厂模式.简单工厂模式.MySQLCourse;

public class MySQLCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new MySQLCourse();
    }
}
