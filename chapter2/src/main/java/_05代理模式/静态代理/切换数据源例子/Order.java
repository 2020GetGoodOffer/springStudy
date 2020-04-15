package _05代理模式.静态代理.切换数据源例子;

public class Order {
    private Object objectInfo;
    private Long createTime;
    private String id;

    public Object getObjectInfo() {
        return objectInfo;
    }

    public void setObjectInfo(Object objectInfo) {
        this.objectInfo = objectInfo;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
