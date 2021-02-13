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
import com.wjzc.project.biz.domain.BsBlrk;
import com.wjzc.project.biz.domain.BsZcyj;
import com.wjzc.project.biz.service.IBsBlrkService;
import com.wjzc.project.biz.service.IBsZctkQylxService;
import com.wjzc.project.biz.service.IBsZctkService;
import com.wjzc.project.biz.service.IBsZcyjService;
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
@RequestMapping("/bszcyj/api")
public class BsZcyjController extends BaseController {

    Logger logger = LoggerFactory.getLogger(BsZcyjController.class);

    @Autowired
    private IBsZcyjService bsZcyjService;

    /**
     * 新增办理入口
     */
    @PreAuthorize("@ss.hasPermi('biz:clause:release')")
    @Log(title = "新增办理入口", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody List<BsZcyj> bsZcyj) {
        return AjaxResult.success(bsZcyjService.insertBsZcyj(bsZcyj));
    }

    /**
     * 查看政策发布详细
     */
    @PreAuthorize("@ss.hasPermi('biz:clause:release')")
    @GetMapping(value = {"/{id}"})
    public AjaxResult getInfo5(@PathVariable Long id) {
        return AjaxResult.success(bsZcyjService.selectBsZcyjById(id));
    }


}
