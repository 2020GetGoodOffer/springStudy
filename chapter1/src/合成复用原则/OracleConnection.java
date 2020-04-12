package 合成复用原则;

public class OracleConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "oracle数据库连接";
    }
}
