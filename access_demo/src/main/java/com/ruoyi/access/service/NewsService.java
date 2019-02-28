package com.ruoyi.access.service;

import com.ruoyi.access.domain.News;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-26 22:11
 */
public interface NewsService {
    /**
     * 返回所有的文章
     * @return
     */
    // TODO 考虑分页返回
    List<News> selectAllNews();

    List<News> selectNewsByPage(int pageNum);

    /**
     * 根据id查询新闻
     * @param id 文章ID
     * @return
     */
    News selectNewsById(String id);
}
