package 接口隔离原则;

public interface IEatAniaml {
    void eat();
}
interface IFlyAniaml {
    void fly();
}
interface ISwimAniaml {
    void swim();
}

class Dog implements IEatAniaml,ISwimAniaml{

    @Override
    public void eat() {

    }

    @Override
    public void swim() {

    }
}
class Bird implements IEatAniaml,IFlyAniaml{

    @Override
    public void eat() {

    }

    @Override
    public void fly() {

    }
}