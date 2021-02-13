/**
 * Project Name:wjzc
 * File Name:WjzcController
 * Package Name:com.wjzc.project.biz.controller
 * Date:2020/3/28 16:05
 * Copyright (c) 2020, cbq@bostech.com All Rights Reserved.
 */
package com.wjzc.project.biz.controller;

import com.wjzc.common.utils.StringUtils;
import com.wjzc.framework.aspectj.lang.enums.BusinessType;
import com.wjzc.framework.web.controller.BaseController;
import com.wjzc.framework.web.domain.AjaxResult;
import com.wjzc.framework.web.page.TableDataInfo;
import com.wjzc.project.biz.domain.*;
import com.wjzc.project.biz.service.*;
import com.wjzc.project.system.domain.SysDictData;
import com.wjzc.framework.aspectj.lang.annotation.Log;
import com.wjzc.project.system.service.ISysDictDataService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author 程碧泉
 * @history 2020/3/28 程碧泉 新建
 * @since JDK1.7
 */

@RestController
@RequestMapping("/bakwjzc/api")
public class WjzcController extends BaseController {

    Logger logger = LoggerFactory.getLogger(WjzcController.class);

    @Autowired
    private IBsLybService bsLybService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ISysDictDataService dictDataService;

    @Autowired
    private IBsZctkService bsZctkService;

    @Autowired
    private IBsZctkQylxService bsZctkQylxService;

    @Autowired
    private IBsZctkLogService bsZctkLogService;

    @Autowired
    private IBsConfigService bsConfigService;


    //@ApiOperation(value = "获取配置", tags = {"五减政策"}, notes = "获取配置")
    @PostMapping(value = "getConfig")
    public AjaxResult getConfig() {
        BsConfig bsConfig = null;
        try {
            bsConfig = bsConfigService.list().get(0);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(bsConfig);
    }

  //  @ApiOperation(value = "关键字搜索", tags = {"五减政策"}, notes = "关键字搜索")
  //  @ApiImplicitParams({@ApiImplicitParam(name = "keyWord", value = "关键字", required = false, dataType = "string", paramType = "query")})
    @PostMapping(value = "search")
    public AjaxResult search(@RequestParam(required = false) String keyWord) {
        List<Map<String, Object>> list = null;
        try {
            list = bsZctkService.search(keyWord);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(list);
    }


  //  @ApiOperation(value = "获取所有分类", tags = {"五减政策"}, notes = "包括五减类型、企业类型、政策类型")
  //  @ApiImplicitParams({@ApiImplicitParam(name = "dictType", value = "分类类型(五减类型[wjlx]、企业类型[qylx]、政策类型[zclx])", required = true, dataType = "string", paramType = "query")})
    @PostMapping(value = "dictdata")
    public AjaxResult dictdata(@RequestParam(required = true) String dictType) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<SysDictData> list = null;
        try {
            list = dictDataService.selectDictDataByType(dictType);
            for (SysDictData sysDictData : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("name", sysDictData.getDictLabel());
                map.put("code", sysDictData.getDictValue());
                resultList.add(map);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(resultList);
    }

    /**
     * 获取政策条款列表  这里 type 就是数据库的字段(为了减少开发的接口，数据库中字段取的名字刚好对应)   有  wjlx,qylx,zclx  value 表示 对应的code的值
     *
     * @param type
     * @param value
     * @return
     */
   // @ApiOperation(value = "根据对应的类型的值获取政策条款列表", tags = {"五减政策"}, notes = "根据五减类型[wjlx]、政策类型[zclx]")
   // @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "分类类型(五减类型[wjlx]、政策类型[zclx])", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "value", value = "对应的值", required = true, dataType = "string", paramType = "query")})
    @PostMapping(value = "list")
    public AjaxResult list(@RequestParam(required = true) String type, @RequestParam(required = true) String value) {
        List<Map<String, Object>> list = null;
        try {
            Map<String, Object> param = new HashMap<>();
            param.put("type", type);
            param.put("value", value);
            list = bsZctkService.selectZctkList(param);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(list);
    }


    /**
     * 获取政策条款列表  这里 type 就是数据库的字段(为了减少开发的接口，数据库中字段取的名字刚好对应)   有  wjlx,qylx,zclx  value 表示 对应的code的值
     *
     * @return
     */
   // @ApiOperation(value = "根据政策类型和企业类型获取条款列表", tags = {"五减政策"}, notes = "根据政策类型和企业类型获取条款列表")
   // @ApiImplicitParams({@ApiImplicitParam(name = "zclx", value = "政策类型", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "qylx", value = "企业类型", required = true, dataType = "string", paramType = "query")})
    @PostMapping(value = "list2")
    public AjaxResult list2(@RequestParam(required = true) String zclx, @RequestParam(required = true) String qylx) {
        List<Map<String, Object>> list = null;
        try {
            Map<String, Object> param = new HashMap<>();
            param.put("zclx", zclx);
            param.put("qylx", qylx);
            list = bsZctkService.selectZctkList2(param);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(list);
    }


    /**
     * 根据Id获取详情
     *
     * @return
     */
 //   @ApiOperation(value = "根据ID获取政策条款", tags = {"五减政策"}, notes = "根据ID获取政策条款")
   // @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "int", paramType = "query")})
    @PostMapping(value = "selectZctk")
    public AjaxResult selectZctk(@RequestParam(required = true) long id) {
        BsZctk bsZctk = null;
        try {
            bsZctk = bsZctkService.selectZctkById(id);
            if (bsZctk != null) {
                BsZctkLog zctkLog = new BsZctkLog();
                zctkLog.setZctkId(id);
                zctkLog.setClickTime(new Date());
                bsZctkLogService.save(zctkLog);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(bsZctk);
    }


   // @ApiOperation(value = "根据企业类型CODE获取政策类型", tags = {"五减政策"}, notes = "根据企业类型获取政策类型")
   // @ApiImplicitParams({@ApiImplicitParam(name = "qylx", value = "企业类型", required = false, dataType = "string", paramType = "query")})
    @PostMapping(value = "selectZclx")
    public AjaxResult selectZclx(@RequestParam(required = true) String qylx) {
        List<Map<String, Object>> list = null;
        try {
            list = bsZctkService.selectZclxByQylx2(qylx);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(list);
    }


 //   @ApiOperation(value = "留言板", tags = {"五减政策"}, notes = "留言板添加留言")
  //  @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "名字", required = false, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "phone", value = "电话", required = false, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "content", value = "留言", required = false, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "anonymous", value = "是否匿名(不匿名[0],匿名[1])", required = false, defaultValue = "0", dataType = "integer", paramType = "query")})
    @PostMapping(value = "addMessage")
    public AjaxResult addMessage(BsLyb bsLyb) {
        try {
            bsLybService.save(bsLyb);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success();
    }


  //  @ApiOperation(value = "五减类型关键字搜索", tags = {"五减政策"}, notes = "五减类型关键字搜索")
  //  @ApiImplicitParams({@ApiImplicitParam(name = "wjlx", value = "五减类型", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "keyWord", value = "关键字", required = false, dataType = "string", paramType = "query")})
    @PostMapping(value = "searchWJLX")
    public AjaxResult searchWJLX(@RequestParam(required = true) String wjlx, @RequestParam(required = false) String keyWord) {
        Map<String, Object> param = new HashMap<>();
        param.put("wjlx", wjlx);
        if (StringUtils.isNotEmpty(keyWord)) {
            param.put("keyWord", keyWord);
        }
        List<Map<String, Object>> list = null;
        try {
            list = bsZctkService.selectByWjlxAndZctk(param);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(list);
    }


 //   @ApiOperation(value = "企业类型关键字搜索", tags = {"五减政策"}, notes = "企业类型关键字搜索")
 //   @ApiImplicitParams({@ApiImplicitParam(name = "qylx", value = "企业类型", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "keyWord", value = "关键字", required = false, dataType = "string", paramType = "query")})
    @PostMapping(value = "searchQYLX")
    public AjaxResult searchQYLX(@RequestParam(required = true) String qylx, @RequestParam(required = false) String keyWord) {
        Map<String, Object> param = new HashMap<>();
        if (StringUtils.isNotBlank(qylx)) {

            param.put("qylx", qylx);
        }
        if (StringUtils.isNotBlank(keyWord)) {
            param.put("keyWord", keyWord);
        }
        List<Map<String, Object>> list = null;
        try {
            list = bsZctkService.selectByQylxAndZctk(param);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(list);
    }


}
