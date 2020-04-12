package _01更好重构项目;

import java.sql.ResultSet;
import java.util.List;

public interface IRowMapper<T> {
    //处理结果集
    T rowMapper(ResultSet resultSet) throws Exception;
}
