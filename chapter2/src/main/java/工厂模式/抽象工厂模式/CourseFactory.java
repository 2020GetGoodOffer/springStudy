package 工厂模式.抽象工厂模式;

public interface CourseFactory {
    INote createNote();
    IVideo createVideo();
}
