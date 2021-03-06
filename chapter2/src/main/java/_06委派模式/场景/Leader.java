package _06委派模式.场景;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {

    private Map<String,IEmployee> targets=new HashMap<>();

    public Leader(){
        targets.put("加密",new EmployeeA());
        targets.put("登陆",new EmployeeB());
    }

    @Override
    public void doing(String command) {
        targets.get(command).doing(command);
    }
}
