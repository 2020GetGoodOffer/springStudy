package _04原型模式.深克隆;

import java.io.*;
import java.util.Date;

public class SunWuKong extends Monkey implements Cloneable, Serializable {

    public Bang bang;
    public SunWuKong(){
        this.birthday=new Date();
        this.bang=new Bang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    public Object deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            SunWuKong copy= (SunWuKong) ois.readObject();
            copy.birthday=new Date();
            return copy;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public SunWuKong shallowClone(SunWuKong target){
        SunWuKong sunWuKong = new SunWuKong();
        sunWuKong.height=target.height;
        sunWuKong.weight=target.weight;
        sunWuKong.birthday=new Date();
        sunWuKong.bang=target.bang;
        return sunWuKong;
    }
}
