package com.ruoyi.access.domain;

import com.ruoyi.common.base.BaseEntity;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-26 10:48
 */
public class AD  extends BaseEntity {

    private String AD_Id;
    private String AD_Img;
    private String AD_Link;
    private String AD_Title;

    public String getAD_Id() {
        return AD_Id;
    }

    public void setAD_Id(String AD_Id) {
        this.AD_Id = AD_Id;
    }

    public String getAD_Img() {
        return AD_Img;
    }

    public void setAD_Img(String AD_Img) {
        this.AD_Img = AD_Img;
    }

    public String getAD_Link() {
        return AD_Link;
    }

    public void setAD_Link(String AD_Link) {
        this.AD_Link = AD_Link;
    }

    public String getAD_Title() {
        return AD_Title;
    }

    public void setAD_Title(String AD_Title) {
        this.AD_Title = AD_Title;
    }
}
