package 工厂模式.工厂方法模式;

import 工厂模式.简单工厂模式.ICourse;
import 工厂模式.简单工厂模式.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }

    public static void main(String[] args) {
        ICourseFactory factory=new JavaCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory=new MySQLCourseFactory();
        course = factory.create();
        course.record();
    }
}
