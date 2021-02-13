/**
 * Project Name:wjzc
 * File Name:BsHotConfig
 * Package Name:com.wjzc.project.biz.domain
 * Date:2020/4/2 11:29
 * Copyright (c) 2020, cbq@bostech.com All Rights Reserved.
 */
package com.wjzc.project.biz.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * TODO
 * @author 程碧泉
 * @since JDK1.7
 * @history 2020/4/2 程碧泉 新建
 */

@Data
@TableName("bs_config")
public class BsConfig {

    private long id;

    private int hotLine;
}
