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
import com.wjzc.project.biz.domain.*;
import com.wjzc.project.biz.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * TODO
 *
 * @author 肖加奇
 * @history 2020/4/15 肖加奇 新建
 * @since JDK1.7
 */

@RestController
@RequestMapping("/bszctk/api")
public class BsZctkController extends BaseController {

    Logger logger = LoggerFactory.getLogger(BsZctkController.class);

    @Autowired
    private IBsZctkService bsZctkService;

    @Autowired
    private IBsZctkQylxService bsZctkQylxService;

    @Autowired
    private IBsBlrkService bsBlrkService;

    /**
     * 获取政策条款列表
     */
    @PreAuthorize("@ss.hasPermi('biz:clause:list')")
    @GetMapping("/list")
    public TableDataInfo list(BsZctk zctk) {
        startPage();
        List<BsZctk> list = bsZctkService.selectBsZctkList(zctk);
        System.out.println("---------"+list);
        return getDataTable(list);
    }

    /**
     * 查询政策条款数量
     */
    @GetMapping(value = "/clicksZctk")
    public AjaxResult getInfo1(BsZctk zctk) {
        int num = bsZctkService.selectBsZctkNum();
        return AjaxResult.success(num);
    }

    /**
     * 查询政策条款占比
     */
    @GetMapping(value = "/raddarchars")
    public AjaxResult getInfo4() {
          List<Map<String, Object>> raddar = bsZctkService.selectBsZctkRaddarList();
        return AjaxResult.success(raddar);
    }

    /**
     * 查询五减类型点击量对比
     */
    @GetMapping(value = "/barchars")
    public AjaxResult getInfo5() {
        Map<String, Object> barList = bsZctkService.selectBsZctkBarList();
        return AjaxResult.success(barList);
    }

    /**
     * 查询政策类型点击量对比
     */
    @GetMapping(value = "/piechars")
    public AjaxResult getInfo6() {
        List<Map<String, Object>> pieList = bsZctkService.selectBsZctkPieList();
        return AjaxResult.success(pieList);
    }

    /**
     * 新增政策条款
     */
    @PreAuthorize("@ss.hasPermi('biz:clause:add')")
    @Log(title = "政策条款", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody BsZctk zctk) {
        return AjaxResult.success(bsZctkService.insertZctk(zctk));
    }

    /**
     * 删除条款
     */
    @PreAuthorize("@ss.hasPermi('biz:clause:remove')")
    @Log(title = "政策条款", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult getInfo(@PathVariable Long id) {

        return toAjax(bsZctkService.deleteWjzcById(id)
        );
    }

    /**
     * 查看条款详细
     */
    @PreAuthorize("@ss.hasPermi('biz:clause:query')")
    @GetMapping(value = {"/{id}"})
    public AjaxResult getInfo2(@PathVariable Long id) {
        return AjaxResult.success(bsZctkService.selectBsZctkById(id));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('biz:clause:edit')")
    @Log(title = "政策条款", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody BsZctk zctk) {
        return AjaxResult.success(bsZctkService.updateWjzc(zctk));
    }




}
