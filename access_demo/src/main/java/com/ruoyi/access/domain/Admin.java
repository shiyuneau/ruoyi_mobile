package com.ruoyi.access.domain;

import com.ruoyi.common.base.BaseEntity;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-26 10:48
 */
public class Admin  extends BaseEntity {
    private String A_Id;
    private String A_Name;
    private String A_Pwd;
    private String A_Flag;
    private String A_Qx;

    public String getA_Id() {
        return A_Id;
    }

    public void setA_Id(String a_Id) {
        A_Id = a_Id;
    }

    public String getA_Name() {
        return A_Name;
    }

    public void setA_Name(String a_Name) {
        A_Name = a_Name;
    }

    public String getA_Pwd() {
        return A_Pwd;
    }

    public void setA_Pwd(String a_Pwd) {
        A_Pwd = a_Pwd;
    }

    public String getA_Flag() {
        return A_Flag;
    }

    public void setA_Flag(String a_Flag) {
        A_Flag = a_Flag;
    }

    public String getA_Qx() {
        return A_Qx;
    }

    public void setA_Qx(String a_Qx) {
        A_Qx = a_Qx;
    }
}
