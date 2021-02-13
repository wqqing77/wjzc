/**
 * Project Name:wjzc
 * File Name:BsZcyj
 * Package Name:com.wjzc.project.biz.domain
 * Date:2020/3/28 14:36
 * Copyright (c) 2020, cbq@bostech.com All Rights Reserved.
 */
package com.wjzc.project.biz.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * TODO
 * @author 程碧泉
 * @since JDK1.7
 * @history 2020/3/28 程碧泉 新建
 */


@Data
@TableName("bs_zcyj")
public class BsZcyj {

    private Long id;

    private Long zctkId;

    private String zcyj;

    private String zcyjurl;

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

    public String getZcyj() {
        return zcyj;
    }

    public void setZcyj(String zcyj) {
        this.zcyj = zcyj;
    }

    public String getZcyjurl() {
        return zcyjurl;
    }

    public void setZcyjurl(String zcyjurl) {
        this.zcyjurl = zcyjurl;
    }
}
