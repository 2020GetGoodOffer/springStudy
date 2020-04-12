package 里氏替换原则;

public class Rectangle implements Quadrangle{

    private long height;
    private long width;

    public long getHeight() {
        return height;
    }

    public long getWidth() {
        return width;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public void setWidth(long width) {
        this.width = width;
    }
}
