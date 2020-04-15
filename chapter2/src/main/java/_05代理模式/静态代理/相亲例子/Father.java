package _05代理模式.静态代理.相亲例子;

public class Father  {

    private Son son;

    public Father(Son son){
        this.son=son;
    }

    public void findLove(){
        System.out.println("父亲物色对象");
        this.son.findLove();
        System.out.println("儿子找对象成功");
    }

    public static void main(String[] args) {
        //只能帮儿子找对象
        Father father=new Father(new Son());
        father.findLove();
    }
}
