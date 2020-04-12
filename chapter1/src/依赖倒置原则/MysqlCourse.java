package 依赖倒置原则;



public class MysqlCourse implements ICourse {

    @Override
    public void study() {
        System.out.println("Kobe在学习MySQL");
    }
}
