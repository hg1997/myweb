package edu.cqupt.utils;

import edu.cqupt.domain.Student;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by hg on 2018/7/16.
 */
public class DBUtils {
    private static Properties props;
    private static DataSource bds;

    static{
        //加载配置文件
        try {
            InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
            props = new Properties();
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过连接池获取数据库连接
     * @return
     * @throws IOException
     * @throws SQLException
     */
    public static Connection getConnection() throws Exception {
        //通过读取到的配置信息获取连接
        if(bds == null){
            synchronized (DBUtils.class){
                if(bds == null){
                    bds = BasicDataSourceFactory.createDataSource(props);
                }
            }
        }
        return bds.getConnection();
    }


    /**
     * 关闭连接
     * @param con
     * @param pstmt
     * @param rs
     */
    public static void closeCon(Connection con, PreparedStatement pstmt, ResultSet rs){
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 添加学生记录
     * @param con
     * @param stu
     */
    public static void addStu(Connection con,Student stu){

    }

    /**
     * 根据学生id删除学生信息
     * @param con
     * @param id
     */
    public static void removeStuById(Connection con,int id){

    }

    /**
     * 修改学生信息
     * @param con
     * @param stu
     */
    public static void updateStu(Connection con,Student stu){

    }



}
