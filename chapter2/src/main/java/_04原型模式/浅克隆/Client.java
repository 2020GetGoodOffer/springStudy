package _04原型模式.浅克隆;

import java.util.ArrayList;

public class Client {
    private Prototype prototype;

    public Client(Prototype prototype){
        this.prototype=prototype;
    }

    public Prototype startClone(){
        return prototype.clone();
    }

    public static void main(String[] args) {
        //创建需要克隆的对象
        ConcretePrototypeA concretePrototypeA=new ConcretePrototypeA();
        //填充属性
        concretePrototypeA.setAge(18);
        concretePrototypeA.setName("prototype");
        concretePrototypeA.setHobbies(new ArrayList<>());
        System.out.println(concretePrototypeA);

        //克隆
        Client client=new Client(concretePrototypeA);
        ConcretePrototypeA concretePrototypeA1= (ConcretePrototypeA) client.startClone();
        System.out.println(concretePrototypeA1);

        System.out.println("克隆对象中引用类型地址:"+concretePrototypeA1.getHobbies().hashCode());
        System.out.println("原对象中引用类型地址："+concretePrototypeA.getHobbies().hashCode());
    }
}
