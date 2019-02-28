package com.ruoyi.common.accessdb;

import com.ruoyi.common.reflect.ReflectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-26 10:09
 */
@Component
public class AccessDBOperateUtils {



    @Autowired
    public static Connection accessConn;

    private static Logger logger = LoggerFactory.getLogger(AccessDBOperateUtils.class);
    public static void main (String[] args) throws Exception{
        List<Link> linkList = new ArrayList<>();
        String sql = "select * from Link where L_Lidro = ?";
        List<Object> paramList = new ArrayList<>();
        paramList.add(3);
        List<Map<String,Object>> list = select(accessConn,sql,paramList);
        logger.info(list.size()+"");
        for(Map<String,Object> mapInfo : list) {
            Link link = new Link();
            for(Map.Entry<String,Object> entry : mapInfo.entrySet()) {
                ReflectUtils.invokeSetter(link,entry.getKey(),entry.getValue());
//                logger.info("key:"+entry.getKey() + "_" +"value:" +entry.getValue() );
            }
            linkList.add(link);
        }
        for (Link link : linkList) {
            System.out.println(link.toString());
        }

    }

    /**
     * 增加、删除、改
     *
     * @param sql    sql
     * @param params 参数
     * @return 添加结果
     */
    public static boolean update(String sql, List<Object> params) throws SQLException {
        int result = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = accessConn;//AccessConnectionUtils.getConn();
            assert conn != null;//直接抛异常
            ps = conn.prepareStatement(sql);
            int index = 1;
            if (params != null && !params.isEmpty()) {
                for (Object param : params) {
                    ps.setObject(index++, param);
                }
            }
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                assert conn != null;
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw e;
        } finally {
            AccessConnectionUtils.close(null, ps, null);
        }
        return result > 0;
    }

    /**
     * 查询多条记录
     *
     * @param sql    sql
     * @param params 参数
     * @return 查询结果
     */
    public static List<Map<String, Object>> select(Connection conn ,String sql, List<Object> params) throws SQLException {
        List<Map<String, Object>> list = new ArrayList<>();
        int index = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            assert conn != null;
            ps = conn.prepareStatement(sql);
            if (params != null && !params.isEmpty()) {
                for (Object param : params) {
                    ps.setObject(index++, param);
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int col_len = metaData.getColumnCount();
            Map<String, Object> map = null;
            while (rs.next()) {
                map = new HashMap<>();
                for (int i = 0; i < col_len; i++) {
                    String cols_name = metaData.getColumnName(i + 1);
                    Object cols_value = rs.getObject(cols_name);
                    if (cols_value == null) {
                        cols_value = "";
                    }
                    map.put(cols_name, cols_value);
                }
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            AccessConnectionUtils.close(null, ps, rs);
        }
        return list;
    }

    /**
     * 通过反射机制查询多条记录
     *
     * @param sql    sql
     * @param params 参数
     * @param clazz  类
     * @return 查询结果
     */
    public static <T> List<T> select(String sql, List<Object> params,
                                     Class<T> clazz) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        List<T> list = new ArrayList<>();
        int index = 1;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = AccessConnectionUtils.getConn();
            assert conn != null;
            ps = conn.prepareStatement(sql);
            if (params != null && !params.isEmpty()) {
                for (Object param : params) {
                    ps.setObject(index++, param);
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int cols_len = metaData.getColumnCount();
            T t;
            while (rs.next()) {
                //通过反射机制创建一个实例
                t = clazz.newInstance();
                for (int i = 0; i < cols_len; i++) {
                    String cols_name = metaData.getColumnName(i + 1);
                    Object cols_value = rs.getObject(cols_name);
                    if (cols_value == null) {
                        cols_value = "";
                    }
                    Field field = clazz.getDeclaredField(cols_name);//获取对象属性
                    field.setAccessible(true); //打开javabean的访问权限
                    field.set(t, cols_value);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            AccessConnectionUtils.close(null, ps, rs);
        }
        return list;
    }
}

class Link {
    private String L_Id;
    private String L_Title;
    private String L_Link;
    private String L_Lidro;

    public String getL_Id() {
        return L_Id;
    }

    public void setL_Id(String l_Id) {
        L_Id = l_Id;
    }

    public String getL_Title() {
        return L_Title;
    }

    public void setL_Title(String l_Title) {
        L_Title = l_Title;
    }

    public String getL_Link() {
        return L_Link;
    }

    public void setL_Link(String l_Link) {
        L_Link = l_Link;
    }

    public String getL_Lidro() {
        return L_Lidro;
    }

    public void setL_Lidro(String l_Lidro) {
        L_Lidro = l_Lidro;
    }

    @Override
    public String toString() {
        return "Link{" +
                "L_ID='" + L_Id + '\'' +
                ", L_Title='" + L_Title + '\'' +
                ", L_Link='" + L_Link + '\'' +
                ", L_Lidro='" + L_Lidro + '\'' +
                '}';
    }
}