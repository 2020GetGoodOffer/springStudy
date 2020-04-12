package 单一职责原则;

public class Course {

    public void study(String courseType){
        if("直播".equals(courseType))
            System.out.println("直播课不能快进");
        else
            System.out.println("录播课可以反复观看");
    }
}
