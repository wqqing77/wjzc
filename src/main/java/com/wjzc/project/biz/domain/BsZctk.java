/**
 * Project Name:wjzc
 * File Name:BsWjzc
 * Package Name:com.wjzc.project.biz.domain
 * Date:2020/3/28 14:26
 * Copyright (c) 2020, cbq@bostech.com All Rights Reserved.
 */
package com.wjzc.project.biz.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("bs_zctk")
public class BsZctk {

    private Long id;

    private String wjlx;


    private String zclx;

    private String zctk;

    private String sydx;

    private String zcsx;

    private String bllc;

    private String bldw;

    private String zxdh;

    private String wjlxCode;


    private String zclxCode;

    private String zctkShort;


    private String dyzc;

    private String tbbm;

    private List<String> qylxCode;

    private int zctknum;

    private String zctknumtime;

    private String value;

    private String name;

    private List<String> sxqCode;

    private String areaCode;

    private Long xh;

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public List<String> getSxqCode() {
        return sxqCode;
    }

    public void setSxqCode(List<String> sxqCode) {
        this.sxqCode = sxqCode;
    }

    public String getZctknumtime() {
        return zctknumtime;
    }

    public void setZctknumtime(String zctknumtime) {
        this.zctknumtime = zctknumtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //    private String value;
//    private String name;
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public int getZctknum() {
        return zctknum;
    }

    public void setZctknum(int zctknum) {
        this.zctknum = zctknum;
    }

    public List<String> getQylxCode() {
        return qylxCode;
    }

    public void setQylxCode(List<String> qylxCode) {
        this.qylxCode = qylxCode;
    }

    @TableField(exist = false)
    private List<BsBlrk> blrkList;

    @TableField(exist = false)
    private List<BsZcyj> zcyjList;

    @TableField(exist = false)
    private Long clickTimes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWjlx() {
        return wjlx;
    }

    public void setWjlx(String wjlx) {
        this.wjlx = wjlx;
    }

    public String getZclx() {
        return zclx;
    }

    public void setZclx(String zclx) {
        this.zclx = zclx;
    }

    public String getZctk() {
        return zctk;
    }

    public void setZctk(String zctk) {
        this.zctk = zctk;
    }

    public String getSydx() {
        return sydx;
    }

    public void setSydx(String sydx) {
        this.sydx = sydx;
    }

    public String getZcsx() {
        return zcsx;
    }

    public void setZcsx(String zcsx) {
        this.zcsx = zcsx;
    }

    public String getBllc() {
        return bllc;
    }

    public void setBllc(String bllc) {
        this.bllc = bllc;
    }

    public String getBldw() {
        return bldw;
    }

    public void setBldw(String bldw) {
        this.bldw = bldw;
    }

    public String getZxdh() {
        return zxdh;
    }

    public void setZxdh(String zxdh) {
        this.zxdh = zxdh;
    }

    public String getWjlxCode() {
        return wjlxCode;
    }

    public void setWjlxCode(String wjlxCode) {
        this.wjlxCode = wjlxCode;
    }

    public String getZclxCode() {
        return zclxCode;
    }

    public void setZclxCode(String zclxCode) {
        this.zclxCode = zclxCode;
    }

    public String getZctkShort() {
        return zctkShort;
    }

    public void setZctkShort(String zctkShort) {
        this.zctkShort = zctkShort;
    }

    public String getDyzc() {
        return dyzc;
    }

    public void setDyzc(String dyzc) {
        this.dyzc = dyzc;
    }

    public String getTbbm() {
        return tbbm;
    }

    public void setTbbm(String tbbm) {
        this.tbbm = tbbm;
    }

    public List<BsBlrk> getBlrkList() {
        return blrkList;
    }

    public void setBlrkList(List<BsBlrk> blrkList) {
        this.blrkList = blrkList;
    }

    public List<BsZcyj> getZcyjList() {
        return zcyjList;
    }

    public void setZcyjList(List<BsZcyj> zcyjList) {
        this.zcyjList = zcyjList;
    }

    public Long getClickTimes() {
        return clickTimes;
    }

    public void setClickTimes(Long clickTimes) {
        this.clickTimes = clickTimes;
    }
}
