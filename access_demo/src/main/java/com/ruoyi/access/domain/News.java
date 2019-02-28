package com.ruoyi.access.domain;

import com.ruoyi.common.base.BaseEntity;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-26 11:02
 */
public class News  extends BaseEntity {

    private String N_Id;
    /**
     * 标题
     */
    private String N_Title;
    /**
     * 内容
     */
    private String N_Content;
    /**
     * 发布时间
     */
    private String N_Date;
    /**
     * 新闻类型
     */
    private String N_Comstye;
    /**
     * 作者
     */
    private String N_Zuozhe;
    /**
     * 点击率
     */
    private String N_Chick;
    /**
     * 文章链接
     */
    private String N_Link;
    /**
     * 文章排序
     */
    private String N_Dorp;
    /**
     * 次数
     */
    private String N_Cs;
    /**
     * 首页
     */
    private String N_Bit;

    public String getN_Id() {
        return N_Id;
    }

    public void setN_Id(String n_Id) {
        N_Id = n_Id;
    }

    public String getN_Title() {
        return N_Title;
    }

    public void setN_Title(String n_Title) {
        N_Title = n_Title;
    }

    public String getN_Content() {
        return N_Content;
    }

    public void setN_Content(String n_Content) {
        N_Content = n_Content;
    }

    public String getN_Date() {
        return N_Date;
    }

    public void setN_Date(String n_Date) {
        N_Date = n_Date;
    }

    public String getN_Comstye() {
        return N_Comstye;
    }

    public void setN_Comstye(String n_Comstye) {
        N_Comstye = n_Comstye;
    }

    public String getN_Zuozhe() {
        return N_Zuozhe;
    }

    public void setN_Zuozhe(String n_Zuozhe) {
        N_Zuozhe = n_Zuozhe;
    }

    public String getN_Chick() {
        return N_Chick;
    }

    public void setN_Chick(String n_Chick) {
        N_Chick = n_Chick;
    }

    public String getN_Link() {
        return N_Link;
    }

    public void setN_Link(String n_Link) {
        N_Link = n_Link;
    }

    public String getN_Dorp() {
        return N_Dorp;
    }

    public void setN_Dorp(String n_Dorp) {
        N_Dorp = n_Dorp;
    }

    public String getN_Cs() {
        return N_Cs;
    }

    public void setN_Cs(String n_Cs) {
        N_Cs = n_Cs;
    }

    public String getN_Bit() {
        return N_Bit;
    }

    public void setN_Bit(String n_Bit) {
        N_Bit = n_Bit;
    }
}
