package _01更好重构项目;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentRowMapper implements IRowMapper<List<Student>> {
    @Override
    public List<Student> rowMapper(ResultSet resultSet) throws Exception {
        List<Student> list=new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            list.add(new Student(id,name));
        }
        return list;
    }
}
