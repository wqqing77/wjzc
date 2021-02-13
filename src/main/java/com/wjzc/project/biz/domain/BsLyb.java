/**
 * Project Name:wjzc
 * File Name:BsLyb
 * Package Name:com.wjzc.project.biz.domain
 * Date:2020/3/28 14:35
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
@TableName("bs_lyb")
public class BsLyb {

    private Long id;

    private String name;

    private String phone;

    private String content;

    private Integer anonymous; //0-不匿名,1-匿名

    private Integer clickslyb;

    public Integer getClickslyb() {
        return clickslyb;
    }

    public void setClickslyb(Integer clickslyb) {
        this.clickslyb = clickslyb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Integer anonymous) {
        this.anonymous = anonymous;
    }
}
