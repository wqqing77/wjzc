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
import com.wjzc.project.biz.domain.BsBlrk;
import com.wjzc.project.biz.domain.BsZctk;
import com.wjzc.project.biz.service.IBsBlrkService;
import com.wjzc.project.biz.service.IBsZctkQylxService;
import com.wjzc.project.biz.service.IBsZctkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author 肖加奇
 * @history 2020/4/15 肖加奇 新建
 * @since JDK1.7
 */

@RestController
@RequestMapping("/bsblrk/api")
public class BsBlrkController extends BaseController {

    Logger logger = LoggerFactory.getLogger(BsBlrkController.class);

    @Autowired
    private IBsZctkService bsZctkService;

    @Autowired
    private IBsZctkQylxService bsZctkQylxService;

    @Autowired
    private IBsBlrkService bsBlrkService;

    /**
     * 新增办理入口
     */
    @PreAuthorize("@ss.hasPermi('biz:clause:entrance')")
    @Log(title = "新增办理入口", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody List<BsBlrk> bsBlrk) {
        return AjaxResult.success(bsBlrkService.insertBsBlrk(bsBlrk));
    }

    /**
     * 删除条款
     */
//    @PreAuthorize("@ss.hasPermi('biz:clause:remove')")
//    @Log(title = "政策条款", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{id}")
//    public AjaxResult getInfo(@PathVariable Long id) {
//
//        return toAjax(bsZctkService.deleteWjzcById(id)
//        );
//    }

    /**
     * 查看条款详细
     */
//    @PreAuthorize("@ss.hasPermi('biz:clause:query')")
//    @GetMapping(value = {"/{id}"})
//    public AjaxResult getInfo2(@PathVariable Long id) {
//        return AjaxResult.success(bsZctkService.selectBsZctkById(id));
//    }

    /**
     * 查看办理入口详细
     */
    @PreAuthorize("@ss.hasPermi('biz:clause:entrance')")
    @GetMapping(value = {"/{id}"})
    public AjaxResult getInfo5(@PathVariable Long id) {

        return AjaxResult.success(bsBlrkService.selectBsBlrkById(id));
    }

    /**
     * 修改
     */
//    @PreAuthorize("@ss.hasPermi('biz:clause:edit')")
//    @Log(title = "政策条款", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult edit(@Validated @RequestBody BsZctk zctk) {
//        return AjaxResult.success(bsZctkService.updateWjzc(zctk));
//    }




}
