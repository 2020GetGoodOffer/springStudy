package _05代理模式.动态代理.JDK;

import _05代理模式.静态代理.相亲例子.Person;

public class Customer implements Person {

    @Override
    public void findLove() {
        System.out.println("要求是36D");
    }

    public static void main(String[] args) {
        try {
            Person person = (Person) new JDKMeipo().getInstance(new Customer());
            person.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
