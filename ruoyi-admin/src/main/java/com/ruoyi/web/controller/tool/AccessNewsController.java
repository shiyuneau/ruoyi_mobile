package com.ruoyi.web.controller.tool;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.access.domain.News;
import com.ruoyi.access.service.NewsService;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author shiyu
 * @Description
 * @create 2019-02-25 12:55
 */
@Controller
@RequestMapping("/access/news")
public class AccessNewsController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(AccessNewsController.class);


    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/all")
    @ResponseBody
    @DataSource(value = DataSourceType.SLAVE)
    public TableDataInfo accessTest() {
        List<News> newsList = newsService.selectAllNews();
        return getDataTable(newsList);
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public TableDataInfo newsByParams(@RequestParam("pageNum") int pageNum) {
        List<News> newsList = newsService.selectNewsByPage(pageNum);
        return getDataTable(newsList);
    }

    @GetMapping(value = "/searchId/{id}")
    @ResponseBody
    public News selectNewsById(@PathVariable("id") String id) {
        return newsService.selectNewsById(id);
    }

}
