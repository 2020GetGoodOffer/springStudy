package 单一职责原则;

public interface ICourse {
    //获得基本信息
    String getMessage();
    //获得视频
    byte[] getVideo();
    //学习课程
    void study();
    //退款
    void refund();
}
