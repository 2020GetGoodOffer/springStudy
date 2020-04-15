package _06委派模式.场景;

public class EmployeeA implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是员工A，我开始干"+command+"工作");
    }
}
