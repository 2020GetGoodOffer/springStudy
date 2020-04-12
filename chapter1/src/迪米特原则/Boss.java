package 迪米特原则;



public class Boss {

    public void commandCheck(Leader leader){
        leader.checkNumberOfCourse();
    }
}
