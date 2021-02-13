/**
 * Project Name:wjzc
 * File Name:WjzcController
 * Package Name:com.wjzc.project.biz.controller
 * Date:2020/3/28 16:05
 * Copyright (c) 2020, cbq@bostech.com All Rights Reserved.
 */
package com.wjzc.project.biz.controller;


import com.wjzc.framework.aspectj.lang.annotation.Log;
import com.wjzc.framework.aspectj.lang.enums.BusinessType;
import com.wjzc.framework.web.controller.BaseController;
import com.wjzc.framework.web.domain.AjaxResult;
import com.wjzc.framework.web.page.TableDataInfo;
import com.wjzc.project.biz.domain.BsLyb;
import com.wjzc.project.biz.domain.BsZctk;
import com.wjzc.project.biz.domain.BsZctkLog;
import com.wjzc.project.biz.service.IBsLybService;
import com.wjzc.project.biz.service.IBsZctkLogService;
import com.wjzc.project.biz.service.IBsZctkQylxService;
import com.wjzc.project.biz.service.IBsZctkService;
import com.wjzc.project.system.domain.SysDictData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author 肖加奇
 * @history 2020/4/16 肖加奇 新建
 * @since JDK1.7
 */

@RestController
@RequestMapping("/bszctklog/api")
public class BsZctkLogController extends BaseController {

    Logger logger = LoggerFactory.getLogger(BsZctkLogController.class);

    @Autowired
    private IBsZctkService bsZctkService;

    @Autowired
    private IBsZctkQylxService bsZctkQylxService;

    @Autowired
    private IBsLybService bsLybService;

    @Autowired
    private IBsZctkLogService bsZctkLogService;


    /**
     * 查询今日点击数量
     */
    @GetMapping(value = "/clicksToday")
    public AjaxResult getInfo(BsZctkLog zctkLog) {
        int num = bsZctkLogService.selectBsZctkLogToDay();
        return AjaxResult.success(num);
    }

    /**
     * 查询累计点击量
     */
    @GetMapping(value = "/clicksCum")
    public AjaxResult getInfo1() {
        int num = bsZctkLogService.selectBsZctkLogCum();
        return AjaxResult.success(num);
    }

    /**
     * 金华累计点击量
     */
    @GetMapping(value = "/clicksJinH")
    public AjaxResult getInfo2() {
        int num = bsZctkLogService.selectBsZctkLogJinH();
        return AjaxResult.success(num);
    }

    /**
     * 婺城累计点击量
     */
    @GetMapping(value = "/clicksWuC")
    public AjaxResult getInfo3() {
        int num = bsZctkLogService.selectBsZctkLogWuC();
        return AjaxResult.success(num);
    }

    /**
     * 金东累计点击量
     */
    @GetMapping(value = "/clicksJingD")
    public AjaxResult getInfo4() {
        int num = bsZctkLogService.selectBsZctkLogJinD();
        return AjaxResult.success(num);
    }

    /**
     * 武义累计点击量
     */
    @GetMapping(value = "/clicksWuY")
    public AjaxResult getInfo5() {
        int num = bsZctkLogService.selectBsZctkLogWuY();
        return AjaxResult.success(num);
    }

    /**
     * 浦江累计点击量
     */
    @GetMapping(value = "/clicksPuJ")
    public AjaxResult getInfo6() {
        int num = bsZctkLogService.selectBsZctkLogPuJ();
        return AjaxResult.success(num);
    }

    /**
     * 磐安累计点击量
     */
    @GetMapping(value = "/clicksBanA")
    public AjaxResult getInfo7() {
        int num = bsZctkLogService.selectBsZctkLogBanA();
        return AjaxResult.success(num);
    }

    /**
     * 兰溪累计点击量
     */
    @GetMapping(value = "/clicksLanX")
    public AjaxResult getInfo8() {
        int num = bsZctkLogService.selectBsZctkLogLanX();
        return AjaxResult.success(num);
    }

    /**
     * 义乌累计点击量
     */
    @GetMapping(value = "/clicksYiW")
    public AjaxResult getInfo9() {
        int num = bsZctkLogService.selectBsZctkLogYiW();
        return AjaxResult.success(num);
    }

    /**
     * 东阳累计点击量
     */
    @GetMapping(value = "/clicksDongY")
    public AjaxResult getInfo10() {
        int num = bsZctkLogService.selectBsZctkLogDongY();
        return AjaxResult.success(num);
    }

    /**
     * 永康累计点击量
     */
    @GetMapping(value = "/clicksYongK")
    public AjaxResult getInfo11() {
        int num = bsZctkLogService.selectBsZctkLogYongK();
        return AjaxResult.success(num);
    }

    /**
     * 开发区累计点击量
     */
    @GetMapping(value = "/clicksKaiFaQ")
    public AjaxResult getInfo12() {
        int num = bsZctkLogService.selectBsZctkLogKaiFaQ();
        return AjaxResult.success(num);
    }


    /**
     * 查询近七天政策条款点击数量
     */
    @GetMapping(value = "/linechars")
    public AjaxResult getInfo2(BsZctkLog zctkLog) {
        List<String> linetime = new ArrayList<>();
       /* List<String> linedata = new ArrayList<>();
        List linelist = new ArrayList<>();
        List<BsZctkLog> line = bsZctkLogService.selectBsZctkClickList(zctkLog);
        for(int i = 0;i<line.size();i++){
            linetime.add(line.get(i).getClitime());
            linedata.add(line.get(i).getClicksdata());
        }
        linelist.add(linetime);
        linelist.add(linedata);  */
        return AjaxResult.success(linetime);
    }



}
