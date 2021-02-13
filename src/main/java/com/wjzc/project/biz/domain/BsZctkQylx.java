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
 * @author 程碧泉
 * @since JDK1.7
 * @history 2020/3/31 程碧泉 新建
 */

@Data
@TableName("bs_zctk_qylx")
public class BsZctkQylx {

    private long id;

    private long zctkId;

    private String qylxCode;

    private String qylx;

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

    public String getQylxCode() {
        return qylxCode;
    }

    public void setQylxCode(String qylxCode) {
        this.qylxCode = qylxCode;
    }

    public String getQylx() {
        return qylx;
    }

    public void setQylx(String qylx) {
        this.qylx = qylx;
    }
}
