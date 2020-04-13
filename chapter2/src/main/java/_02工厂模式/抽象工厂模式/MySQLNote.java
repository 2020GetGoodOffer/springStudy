package _02工厂模式.抽象工厂模式;

public class MySQLNote implements INote {
    @Override
    public void edit() {
        System.out.println("编写MySQL笔记");
    }
}
