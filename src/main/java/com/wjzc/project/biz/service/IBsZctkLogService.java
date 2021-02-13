package com.wjzc.project.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wjzc.project.biz.domain.BsZctkLog;

import java.util.List;

/**
 * @author wjzc
 */
public interface IBsZctkLogService extends IService<BsZctkLog> {


    /**
     * 今日点击量
     * @author wjzc
     */
    public Integer selectBsZctkLogToDay();

    /**
     * 累计点击量
     * @author wjzc
     */
    public Integer selectBsZctkLogCum();

    /**
     * 金华累计点击量
     * @author wjzc
     */
    public Integer selectBsZctkLogJinH();

    /**
     * 婺城累计点击量
     * @author wjzc
     */
    public Integer selectBsZctkLogWuC();

    /**
     * 金东累计点击量
     * @author wjzc
     */
    public Integer selectBsZctkLogJinD();

    /**
     * 武义累计点击量
     * @author wjzc
     */
    public Integer selectBsZctkLogWuY();

    /**
     * 浦江累计点击量
     * @author wjzc
     */
    public Integer selectBsZctkLogPuJ();

    /**
     * 磐安累计点击量
     * @author wjzc
     */
    public Integer selectBsZctkLogBanA();

    /**
     * 兰溪累计点击量
     * @author wjzc
     */
    public Integer selectBsZctkLogLanX();

    /**
     * 义乌累计点击量
     * @author wjzc
     */
    public Integer selectBsZctkLogYiW();

    /**
     * 东阳累计点击量
     * @author wjzc
     */
    public Integer selectBsZctkLogDongY();

    /**
     * 永康累计点击量
     * @author wjzc
     */
    public Integer selectBsZctkLogYongK();

    /**
     * 开发区累计点击量
     * @author wjzc
     */
    public Integer selectBsZctkLogKaiFaQ();

    /**
     * 查询近七天政策条款点击数量
     * @author wjzc
     */
    public List<BsZctkLog> selectBsZctkClickList(BsZctkLog zctkLog);
}
