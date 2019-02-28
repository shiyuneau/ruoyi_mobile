package com.ruoyi.access.domain;

import com.ruoyi.common.base.BaseEntity;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-26 10:48
 */
public class Comstye  extends BaseEntity {
    private String Com_Id;
    /**
     * 父级ID
     */
    private String Com_Fid;
    /**
     * 分类名称
     */
    private String Com_Stye;
    /**
     * 所属主题
     */
    private String Com_Topic;
    /**
     * 排序
     */
    private String Com_OrderId;
    /**
     * 自定义链接
     */
    private String Com_Link;
    /**
     * 特殊的登陆密码
     */
    private String Com_PassWord;
    /**
     * 属于哪一面的
     */
    private String Com_LR;
    /**
     * 主题颜色
     */
    private String Com_AColor;
    /**
     * 内容颜色
     */
    private String Com_ZColor;
    /**
     * 放上的颜色
     */
    private String Com_FColor;

    public String getCom_Id() {
        return Com_Id;
    }

    public void setCom_Id(String com_Id) {
        Com_Id = com_Id;
    }

    public String getCom_Fid() {
        return Com_Fid;
    }

    public void setCom_Fid(String com_Fid) {
        Com_Fid = com_Fid;
    }

    public String getCom_Stye() {
        return Com_Stye;
    }

    public void setCom_Stye(String com_Stye) {
        Com_Stye = com_Stye;
    }

    public String getCom_Topic() {
        return Com_Topic;
    }

    public void setCom_Topic(String com_Topic) {
        Com_Topic = com_Topic;
    }

    public String getCom_OrderId() {
        return Com_OrderId;
    }

    public void setCom_OrderId(String com_OrderId) {
        Com_OrderId = com_OrderId;
    }

    public String getCom_Link() {
        return Com_Link;
    }

    public void setCom_Link(String com_Link) {
        Com_Link = com_Link;
    }

    public String getCom_PassWord() {
        return Com_PassWord;
    }

    public void setCom_PassWord(String com_PassWord) {
        Com_PassWord = com_PassWord;
    }

    public String getCom_LR() {
        return Com_LR;
    }

    public void setCom_LR(String com_LR) {
        Com_LR = com_LR;
    }

    public String getCom_AColor() {
        return Com_AColor;
    }

    public void setCom_AColor(String com_AColor) {
        Com_AColor = com_AColor;
    }

    public String getCom_ZColor() {
        return Com_ZColor;
    }

    public void setCom_ZColor(String com_ZColor) {
        Com_ZColor = com_ZColor;
    }

    public String getCom_FColor() {
        return Com_FColor;
    }

    public void setCom_FColor(String com_FColor) {
        Com_FColor = com_FColor;
    }
}
