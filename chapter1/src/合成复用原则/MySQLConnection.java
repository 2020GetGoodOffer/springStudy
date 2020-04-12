package 合成复用原则;

public class MySQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "mysql数据库连接";
    }
}
