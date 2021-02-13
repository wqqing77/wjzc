package com.wjzc.project.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjzc.project.biz.domain.BsBlrk;
import com.wjzc.project.biz.domain.BsZctkQylx;
import com.wjzc.project.biz.mapper.BsBlrkMapper;
import com.wjzc.project.biz.mapper.BsZctkQylxMapper;
import com.wjzc.project.biz.service.IBsBlrkService;
import com.wjzc.project.biz.service.IBsZctkQylxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 政策条款-办理入口及依据 业务层处理
 *
 * @author wjzc
 */
@Service
public class BsBlrkServiceImpl extends ServiceImpl<BsBlrkMapper, BsBlrk> implements IBsBlrkService {

    private static final Logger log = LoggerFactory.getLogger(BsBlrkServiceImpl.class);

    @Autowired
    private BsBlrkMapper bsBlrkMappers;


    /**
     * 根据对应政策条款ID，新增相应办理入口
     * @return 结果
     */
    @Override
    @Transactional
    public int insertBsBlrk(List<BsBlrk> bsBlrk) {

        //查询出对应的政策条款id
        long zctkId = bsBlrk.get(0).getZctkId();
        //根据对应政策id查看是否有办理入口及链接数据
       // List<BsBlrk> bsBlrks = bsBlrkMappers.selectBsBlrkById(id);
        //if(bsBlrks.size() > 0){
            //如果有数据则先删除
        bsBlrkMappers.deleteBsBlrksById(zctkId);
      //  }
        for (int i=0;i<bsBlrk.size();i++){
            BsBlrk bs = bsBlrk.get(i);
            bsBlrkMappers.insertBsBlrk(bs);
        }

        return 1;
    }

    /**
     * 根据对应政策条款ID，查询相应办理入口
     * @return 结果
     */
    @Override
    public List<BsBlrk> selectBsBlrkById(Long id) {
        List<BsBlrk> bsBlrks = bsBlrkMappers.selectBsBlrkById(id);
        return bsBlrks;
    }

}
