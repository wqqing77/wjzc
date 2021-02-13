package com.wjzc.project.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjzc.project.biz.domain.BsConfig;
import com.wjzc.project.biz.mapper.BsConfigMapper;
import com.wjzc.project.biz.mapper.BsZctkLogMapper;
import com.wjzc.project.biz.service.IBsConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户 业务层处理
 *
 * @author wjzc
 */
@Service
public class BsConfigServiceImpl extends ServiceImpl<BsConfigMapper, BsConfig> implements IBsConfigService {

    private static final Logger log = LoggerFactory.getLogger(BsConfigServiceImpl.class);

    @Autowired
    private BsConfigMapper bsConfigMapper;

}
