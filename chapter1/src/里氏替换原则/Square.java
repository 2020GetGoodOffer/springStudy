package 里氏替换原则;

public class Square implements Quadrangle {

    private long length;

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    @Override
    public long getHeight() {
        return getLength();
    }

    @Override
    public long getWidth() {
        return getLength();
    }

}
