package 单一职责原则;

public class Test {

    public void modifyUserInfo(String username,String address){
        //分别修改用户名和地址
    }
    public void modifyUserName(String username){
        //分别修改用户名
    }
    public void modifyUserAddress(String address){
        //分别修改地址
    }
    public static void main(String[] args) {
        new LiveCourse().study("直播课");
        new ReplayCourse().study("录播课");
    }
}
