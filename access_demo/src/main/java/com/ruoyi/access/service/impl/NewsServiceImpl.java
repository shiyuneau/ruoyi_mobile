package com.ruoyi.access.service.impl;

import com.ruoyi.access.domain.News;
import com.ruoyi.access.dao.NewsDao;
import com.ruoyi.access.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-26 22:12
 */

@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> selectAllNews() {
        return newsDao.selectAllNews();
    }

    @Override
    public List<News> selectNewsByPage(int pageNum) {
        return newsDao.selectNewsByPage(pageNum);
    }

    @Override
    public News selectNewsById(String id) {
        return newsDao.selectNewsById(id);
    }
}
