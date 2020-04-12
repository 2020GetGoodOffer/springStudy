package 工厂模式.抽象工厂模式;

public class MySQLCourseFactory implements CourseFactory {
    @Override
    public INote createNote() {
        return new MySQLNote();
    }

    @Override
    public IVideo createVideo() {
        return new MySQLVideo();
    }
}
