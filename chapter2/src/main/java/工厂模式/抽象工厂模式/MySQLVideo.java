package 工厂模式.抽象工厂模式;

public class MySQLVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("录制MySQL课程");
    }
}
