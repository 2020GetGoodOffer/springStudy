package 迪米特原则;

import java.util.ArrayList;
import java.util.List;

public class Leader extends Boss {
    public void checkNumberOfCourse(){
        List<Course> courseList=new ArrayList<>();
        for(int i=0;i<20;i++)
            courseList.add(new Course());
        System.out.println("目前已上线的课数量是"+courseList.size());
    }
}
