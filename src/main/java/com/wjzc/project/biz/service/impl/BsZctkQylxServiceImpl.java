package com.wjzc.project.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjzc.project.biz.domain.BsZctkQylx;
import com.wjzc.project.biz.mapper.BsZctkQylxMapper;
import com.wjzc.project.biz.service.IBsZctkQylxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 政策条款-企业类型 业务层处理
 *
 * @author wjzc
 */
@Service
public class BsZctkQylxServiceImpl extends ServiceImpl<BsZctkQylxMapper, BsZctkQylx> implements IBsZctkQylxService {

    private static final Logger log = LoggerFactory.getLogger(BsZctkQylxServiceImpl.class);

    @Autowired
    private BsZctkQylxMapper bsZctkQylxMapper;


    /**
     * 新增政策条款信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertZctkQylx(BsZctkQylx zctkQylx) {
        //
        int rows = bsZctkQylxMapper.insertZctkQylx(zctkQylx);
        return rows;
    }

    /**
     * 根据对应政策条款ID，删除相应企业类型
     * @return 结果
     */
    @Override
    public int deleteWjzcQylxById(Long id) {
        return bsZctkQylxMapper.deleteWjzcQylxById(id);
    }

}
