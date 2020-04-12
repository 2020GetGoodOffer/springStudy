package _01更好重构项目;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModifyStuInfo {

    public void save(Student student){
        String sql="insert into t_student(id,name) values (?,?)";
        Object[] params=new Object[]{student.getId(),student.getName()};
        JDBCTemplate.update(sql,params);
    }


    public void delete(Integer id){
        String sql="delete from t_student where id=?";
        JDBCTemplate.update(sql,id);
    }

    public List<Student> queryAll(){
        String sql="select * from t_student";
        return JDBCTemplate.queryAll(sql,new StudentRowMapper());
    }

    public Integer getCount(){
        String sql="select count(*) from t_student";
        return JDBCTemplate.queryAll(sql, new IRowMapper<Integer>() {
            @Override
            public Integer rowMapper(ResultSet resultSet) throws Exception {
                Integer count1 =null;
                if(resultSet.next())
                    count1 =resultSet.getInt("total");
                return count1;
            }
        });
    }
}
