/**
 * Project Name:wjzc
 * File Name:BsBlrk
 * Package Name:com.wjzc.project.biz.domain
 * Date:2020/3/28 14:35
 * Copyright (c) 2020, cbq@bostech.com All Rights Reserved.
 */
package com.wjzc.project.biz.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * TODO
 * @author 程碧泉
 * @since JDK1.7
 * @history 2020/3/28 程碧泉 新建
 */

@Data
@TableName("bs_blrk")
public class BsBlrk {

    private Long id;

    private Long zctkId;

    private String blrk;//

    private String blrkurl;

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

    public String getBlrk() {
        return blrk;
    }

    public void setBlrk(String blrk) {
        this.blrk = blrk;
    }

    public String getBlrkurl() {
        return blrkurl;
    }

    public void setBlrkurl(String blrkurl) {
        this.blrkurl = blrkurl;
    }
}
