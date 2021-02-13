/**
 * Project Name:wjzc
 * File Name:BsZctkQylx
 * Package Name:com.wjzc.project.biz.domain
 * Date:2020/3/31 10:02
 * Copyright (c) 2020, cbq@bostech.com All Rights Reserved.
 */
package com.wjzc.project.biz.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * TODO
 * @author 肖加奇
 * @since JDK1.7
 * @history 2020/5/9 肖加奇 新建
 */

@Data
@TableName("sys_area_zctk")
public class BsAreaZctk {

    private long id;

    private long zctkId;

    private String areaCode;

    private String areaName;

    private String cityname;

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getZctkId() {
        return zctkId;
    }

    public void setZctkId(long zctkId) {
        this.zctkId = zctkId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
