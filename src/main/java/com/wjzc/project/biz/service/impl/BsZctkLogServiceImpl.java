package com.wjzc.project.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjzc.project.biz.domain.BsLyb;
import com.wjzc.project.biz.domain.BsZctk;
import com.wjzc.project.biz.domain.BsZctkLog;
import com.wjzc.project.biz.mapper.BsZctkLogMapper;
import com.wjzc.project.biz.mapper.BsZctkMapper;
import com.wjzc.project.biz.service.IBsZctkLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户 业务层处理
 *
 * @author wjzc
 */
@Service
public class BsZctkLogServiceImpl extends ServiceImpl<BsZctkLogMapper, BsZctkLog> implements IBsZctkLogService {

    private static final Logger log = LoggerFactory.getLogger(BsZctkLogServiceImpl.class);

    @Autowired
    private BsZctkLogMapper bsZctkLogMapper;

    /**
     * 获取今日点击量
     */
    public Integer selectBsZctkLogToDay() {
        return bsZctkLogMapper.selectBsZctkLogToDay();
    }

    /**
     * 获取累计点击量  selectBsZctkLogJinH
     */
    public Integer selectBsZctkLogCum() {
        return bsZctkLogMapper.selectBsZctkLogCum();
    }

    /**
     * 金华市累计点击量
     */
    public Integer selectBsZctkLogJinH() {
        return bsZctkLogMapper.selectBsZctkLogJinH();
    }

    /**
     * 婺城累计点击量
     */
    public Integer selectBsZctkLogWuC() {
        return bsZctkLogMapper.selectBsZctkLogWuC();
    }

    /**
     * 金东累计点击量
     */
    public Integer selectBsZctkLogJinD() {
        return bsZctkLogMapper.selectBsZctkLogJinD();
    }

    /**
     * 武义累计点击量
     */
    public Integer selectBsZctkLogWuY() {
        return bsZctkLogMapper.selectBsZctkLogWuY();
    }

    /**
     * 浦江累计点击量
     */
    public Integer selectBsZctkLogPuJ() {
        return bsZctkLogMapper.selectBsZctkLogPuJ();
    }

    /**
     * 磐安累计点击量
     */
    public Integer selectBsZctkLogBanA() {
        return bsZctkLogMapper.selectBsZctkLogBanA();
    }

    /**
     * 兰溪累计点击量
     */
    public Integer selectBsZctkLogLanX() {
        return bsZctkLogMapper.selectBsZctkLogLanX();
    }

    /**
     * 义乌累计点击量
     */
    public Integer selectBsZctkLogYiW() {
        return bsZctkLogMapper.selectBsZctkLogYiW();
    }

    /**
     * 东阳累计点击量
     */
    public Integer selectBsZctkLogDongY() {
        return bsZctkLogMapper.selectBsZctkLogDongY();
    }

    /**
     * 永康累计点击量
     */
    public Integer selectBsZctkLogYongK() {
        return bsZctkLogMapper.selectBsZctkLogYongK();
    }

    /**
     * 开发区累计点击量
     */
    public Integer selectBsZctkLogKaiFaQ() {
        return bsZctkLogMapper.selectBsZctkLogKaiFaQ();
    }

    /**
     * 查询近七天政策条款点击数量
     * @author wjzc
     */
    public List<BsZctkLog> selectBsZctkClickList(BsZctkLog zctkLog) {
        return bsZctkLogMapper.selectBsZctkClickList(zctkLog);
    }

}
