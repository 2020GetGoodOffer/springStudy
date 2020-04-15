package _04原型模式.深克隆;

public class Test {

    public static void main(String[] args) {
        SunWuKong sunWuKong = new SunWuKong();
        try{
            SunWuKong clone= (SunWuKong) sunWuKong.clone();
            System.out.println("深克隆："+(sunWuKong.bang==clone.bang));
        }catch (Exception e){
            e.printStackTrace();
        }
        SunWuKong sunWuKong1 = new SunWuKong();
        SunWuKong sunWuKong2 = sunWuKong1.shallowClone(sunWuKong1);
        System.out.println("浅克隆："+(sunWuKong1.bang==sunWuKong2.bang));
    }
}
