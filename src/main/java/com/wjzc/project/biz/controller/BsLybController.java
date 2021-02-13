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
import com.wjzc.project.biz.service.IBsLybService;
import com.wjzc.project.biz.service.IBsZctkQylxService;
import com.wjzc.project.biz.service.IBsZctkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author 肖加奇
 * @history 2020/4/15 肖加奇 新建
 * @since JDK1.7
 */

@RestController
@RequestMapping("/lyb/api")
public class BsLybController extends BaseController {

    Logger logger = LoggerFactory.getLogger(BsLybController.class);

    @Autowired
    private IBsZctkService bsZctkService;

    @Autowired
    private IBsZctkQylxService bsZctkQylxService;

    @Autowired
    private IBsLybService bsLybService;

    /**
     * 获取政策条款列表
     */
    @PreAuthorize("@ss.hasPermi('biz:lyb:list')")
    @GetMapping("/list")
    public TableDataInfo list(BsLyb lyb) {
        startPage();
        List<BsLyb> list = bsLybService.selectBsLybList(lyb);
        System.out.println("---------"+list);
        return getDataTable(list);
    }

    /**
     * 查询留言数量
     */
    @GetMapping(value = "/clicksLyb")
    public AjaxResult getInfo1(BsLyb lyb) {
        int num = bsLybService.selectBsLybNum();
        return AjaxResult.success(num);
    }

    /**
     * 删除条款
     */
    @PreAuthorize("@ss.hasPermi('biz:lyb:remove')")
    @Log(title = "留言板", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id) {
        return toAjax(bsLybService.deleteBsLybById(id)
        );
    }

    /**
     * 查看条款详细
     */
    @PreAuthorize("@ss.hasPermi('biz:lyb:query')")
    @GetMapping(value = {"/{id}"})
    public AjaxResult getInfo2(@PathVariable Long id) {
        return AjaxResult.success(bsZctkService.selectBsZctkById(id));
    }



}
