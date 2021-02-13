/**
 * Project Name:wjzc
 * File Name:BsZctkLog
 * Package Name:com.wjzc.project.biz.domain
 * Date:2020/3/28 14:35
 * Copyright (c) 2020, cbq@bostech.com All Rights Reserved.
 */
package com.wjzc.project.biz.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * TODO
 * @author 程碧泉
 * @since JDK1.7
 * @history 2020/3/28 程碧泉 新建
 */

@Data
@TableName("bs_zctk_log")
public class BsZctkLog {

    private Long id;

    private Long zctkId;

    private Date clickTime;

    private Integer clickstoday;

    private Integer clickscum;

    private String clitime;

    private String clicksdata;

    private String areaCode;

    public String getClicksdata() {
        return clicksdata;
    }

    public void setClicksdata(String clicksdata) {
        this.clicksdata = clicksdata;
    }

    public String getClitime() {
        return clitime;
    }

    public void setClitime(String clitime) {
        this.clitime = clitime;
    }

    public Integer getClickstoday() {
        return clickstoday;
    }

    public void setClickstoday(Integer clickstoday) {
        this.clickstoday = clickstoday;
    }

    public Integer getClickscum() {
        return clickscum;
    }

    public void setClickscum(Integer clickscum) {
        this.clickscum = clickscum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getZctkId() {
        return zctkId;
    }

    public void setZctkId(Long zctkId) {
        this.zctkId = zctkId;
    }

    public Date getClickTime() {
        return clickTime;
    }

    public void setClickTime(Date clickTime) {
        this.clickTime = clickTime;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
