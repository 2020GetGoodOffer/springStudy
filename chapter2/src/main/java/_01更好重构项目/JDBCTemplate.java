package _01更好重构项目;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplate {

    public static void update(String sql,Object[] params){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            //获取连接
            connection= JDBCUtil.getConnection();
            //创建语句对象
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                preparedStatement.setObject(i+1,params[i]);
            }
            //执行语句
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(null,preparedStatement,connection);
        }
    }

    public static void update(String sql,Integer id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            //获取连接
            connection= JDBCUtil.getConnection();
            //创建语句对象
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setObject(1,id);
            //执行语句
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(null,preparedStatement,connection);
        }
    }

    public static<T> T queryAll(String sql,IRowMapper<T> mapper,Object...params){
        List<Student> list=new ArrayList<>();
        ResultSet resultSet=null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            //获取连接
            connection= JDBCUtil.getConnection();
            //创建语句对象
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                preparedStatement.setObject(i+1,params[i]);
            }
            //执行语句
            resultSet = preparedStatement.executeQuery();
            return mapper.rowMapper(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
        return null;
    }
}
