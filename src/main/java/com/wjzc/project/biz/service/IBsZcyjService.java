package com.wjzc.project.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wjzc.project.biz.domain.BsBlrk;
import com.wjzc.project.biz.domain.BsZcyj;

import java.util.List;

/**
 * @author wjzc
 */
public interface IBsZcyjService extends IService<BsZcyj> {

    /**
     * 通过条款ID查询相应办理入口及链接
     *
     * @return 结果
     */
    public List<BsZcyj> selectBsZcyjById(Long id);

    /**
     * 通过条款ID删除办理入口及链接
     *
     * @return 结果
     */
   // public int deleteBsBlrksById(Long id);

    /**
     * 新增办理入口及链接
     * @author wjzc
     */
    public int insertBsZcyj(List<BsZcyj> bsZcyj);
}
