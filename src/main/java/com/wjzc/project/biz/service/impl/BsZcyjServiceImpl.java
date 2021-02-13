package com.wjzc.project.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjzc.project.biz.domain.BsBlrk;
import com.wjzc.project.biz.domain.BsZcyj;
import com.wjzc.project.biz.mapper.BsBlrkMapper;
import com.wjzc.project.biz.mapper.BsZcyjMapper;
import com.wjzc.project.biz.service.IBsBlrkService;
import com.wjzc.project.biz.service.IBsZcyjService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 政策条款-办理入口及依据 业务层处理
 *
 * @author wjzc
 */
@Service
public class BsZcyjServiceImpl extends ServiceImpl<BsZcyjMapper, BsZcyj> implements IBsZcyjService {

    private static final Logger log = LoggerFactory.getLogger(BsZcyjServiceImpl.class);

    @Autowired
    private BsZcyjMapper bsZcyjMapper;


    /**
     * 根据对应政策条款ID，新增相应办理入口
     * @return 结果
     */
    @Override
    @Transactional
    public int insertBsZcyj(List<BsZcyj> bsZcyj) {

        //查询出对应的政策条款id
        long zctkId = bsZcyj.get(0).getZctkId();
        //如果有数据则先删除
        bsZcyjMapper.deleteBsZcyjById(zctkId);
        for (int i=0;i<bsZcyj.size();i++){
            BsZcyj b = bsZcyj.get(i);
            bsZcyjMapper.insertBsZcyj(b);
        }

        return 1;
    }

    /**
     * 根据对应政策条款ID，查询相应政策发布及链接
     * @return 结果
     */
    @Override
    public List<BsZcyj> selectBsZcyjById(Long id) {
        List<BsZcyj> bsZcyjs = bsZcyjMapper.selectBsZcyjById(id);
        return bsZcyjs;
    }

}
