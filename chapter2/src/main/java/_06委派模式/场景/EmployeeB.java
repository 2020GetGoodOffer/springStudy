package _06委派模式.场景;

public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是员工B，我开始干"+command+"工作");
    }
}
