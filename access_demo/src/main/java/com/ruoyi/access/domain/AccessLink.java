package com.ruoyi.access.domain;

import com.ruoyi.common.base.BaseEntity;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-26 10:48
 */
public class AccessLink extends BaseEntity {

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
}
