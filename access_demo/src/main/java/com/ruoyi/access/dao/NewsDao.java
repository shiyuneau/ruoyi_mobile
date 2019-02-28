package com.ruoyi.access.dao;

import com.ruoyi.access.domain.News;
import com.ruoyi.common.constant.AccessConstants;
import com.ruoyi.common.reflect.ReflectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.ruoyi.common.accessdb.AccessDBOperateUtils.select;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-26 22:07
 */
@Repository
public class NewsDao {

    @Autowired
    private Connection accessConn;

    public List<News> selectAllNews() {
        List<News> linkList = new ArrayList<>();
        try {
            String sql = "select * from News";
            List<Object> paramList = new ArrayList<>();
            List<Map<String, Object>> list = select(accessConn, sql, paramList);
            for (Map<String, Object> mapInfo : list) {
                News news = new News();
                for (Map.Entry<String, Object> entry : mapInfo.entrySet()) {
                    ReflectUtils.invokeSetter(news, entry.getKey(), entry.getValue());
                }
                linkList.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linkList;
    }

    public List<News> selectNewsByPage(int pageNum) {
        // 已经读取的数据 如果为0 ， 则代表 第一页
        int readedCount = AccessConstants.PAGE_SIZE*(pageNum-1);
        String sql;
        if (readedCount ==0) {
            sql = "SELECT  top " + AccessConstants.PAGE_SIZE + " * from News order by N_Id";
        } else {
            sql ="SELECT  top " + AccessConstants.PAGE_SIZE + " * from News where (N_Id > (select MAX(N_Id) from ( select top "+ readedCount +" N_Id from News order by N_Id) as T)) order by N_Id ";
        }
        List<News> linkList = new ArrayList<>();
        try {
            List<Object> paramList = new ArrayList<>();
            List<Map<String, Object>> list = select(accessConn, sql, paramList);
            if (null!=list && list.size()>0) {
                for (Map<String, Object> mapInfo : list) {
                    News news = new News();
                    for (Map.Entry<String, Object> entry : mapInfo.entrySet()) {
                        ReflectUtils.invokeSetter(news, entry.getKey(), entry.getValue());
                    }
                    linkList.add(news);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linkList;
    }


    public News selectNewsById(String id) {
        News news = new News();
        try {
            String sql = "select * from News where N_Id = ?";
            List<Object> paramList = new ArrayList<>();
            paramList.add(id);
            List<Map<String, Object>> list = select(accessConn, sql, paramList);
            for (Map<String, Object> mapInfo : list) {
                for (Map.Entry<String, Object> entry : mapInfo.entrySet()) {
                    ReflectUtils.invokeSetter(news, entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

}
