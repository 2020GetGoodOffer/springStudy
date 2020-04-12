package 迪米特原则;

public class Test {

    public static void main(String[] args) {
        Boss boss = new Boss();
        Leader leader = new Leader();
        boss.commandCheck(leader);
    }
}
