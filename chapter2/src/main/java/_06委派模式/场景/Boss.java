package _06委派模式.场景;

public class Boss {

    public void command(String command,Leader leader){
        leader.doing(command);
    }

    public static void main(String[] args) {
        new Boss().command("登陆",new Leader());
    }
}
