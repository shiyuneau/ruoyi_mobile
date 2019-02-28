package com.ruoyi.access.domain;

import com.ruoyi.common.base.BaseEntity;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-26 11:02
 */
public class Corporate  extends BaseEntity {

    private String C_id;
    /**
     * 公司全称
     */
    private String C_name;
    /**
     * 公司地址
     */
    private String C_press;
    /**
     * 联系电话
     */
    private String C_phone;
    /**
     * 传真
     */
    private String C_fax;
    /**
     * 邮编
     */
    private String C_pc;
    /**
     * 电子邮箱
     */
    private String C_mail;
    /**
     * 联系人
     */
    private String C_user;
    /**
     * 网站描述
     */
    private String description;
    /**
     * 网站关键词
     */
    private String keywords;
    /**
     * 备案号
     */
    private String beian;
    /**
     * 优化词
     */
    private String youhua;


    public String getC_id() {
        return C_id;
    }

    public void setC_id(String c_id) {
        C_id = c_id;
    }

    public String getC_name() {
        return C_name;
    }

    public void setC_name(String c_name) {
        C_name = c_name;
    }

    public String getC_press() {
        return C_press;
    }

    public void setC_press(String c_press) {
        C_press = c_press;
    }

    public String getC_phone() {
        return C_phone;
    }

    public void setC_phone(String c_phone) {
        C_phone = c_phone;
    }

    public String getC_fax() {
        return C_fax;
    }

    public void setC_fax(String c_fax) {
        C_fax = c_fax;
    }

    public String getC_pc() {
        return C_pc;
    }

    public void setC_pc(String c_pc) {
        C_pc = c_pc;
    }

    public String getC_mail() {
        return C_mail;
    }

    public void setC_mail(String c_mail) {
        C_mail = c_mail;
    }

    public String getC_user() {
        return C_user;
    }

    public void setC_user(String c_user) {
        C_user = c_user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getBeian() {
        return beian;
    }

    public void setBeian(String beian) {
        this.beian = beian;
    }

    public String getYouhua() {
        return youhua;
    }

    public void setYouhua(String youhua) {
        this.youhua = youhua;
    }
}
