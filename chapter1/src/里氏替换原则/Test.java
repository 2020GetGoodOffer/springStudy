package 里氏替换原则;

public class Test {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(10);
        rectangle.setWidth(20);
        resize(rectangle);
    }

    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth()>=rectangle.getHeight()){
            rectangle.setHeight(rectangle.getHeight()+1);
            System.out.println(rectangle.getWidth()+" , "+rectangle.getHeight());
        }
        System.out.println("resize方法结束"+rectangle.getWidth()+" , "+rectangle.getHeight());
    }
}
