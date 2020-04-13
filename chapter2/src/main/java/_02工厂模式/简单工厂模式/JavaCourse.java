package _02工厂模式.简单工厂模式;

public class JavaCourse implements ICourse {

    public void record() {
        System.out.println("录制Java课程");
    }

    public static void main(String[] args) {
        CourseFactory factory = new CourseFactory();
        ICourse course = factory.create(JavaCourse.class);
        course.record();
    }

}
