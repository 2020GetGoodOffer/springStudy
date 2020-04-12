package 依赖倒置原则;

public class Kobe {

    private ICourse course;

    public void setCourse(ICourse course) {
        this.course = course;
    }

    public void study(){
        course.study();
    }

    public static void main(String[] args) {
        Kobe kobe = new Kobe();
        kobe.setCourse(new JavaCourse());
        kobe.study();
    }
}
