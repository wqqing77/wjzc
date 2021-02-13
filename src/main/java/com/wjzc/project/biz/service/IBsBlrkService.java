package com.wjzc.project.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wjzc.project.biz.domain.BsBlrk;
import com.wjzc.project.biz.domain.BsZctkQylx;

import java.util.List;

/**
 * @author wjzc
 */
public interface IBsBlrkService extends IService<BsBlrk> {

    /**
     * 通过条款ID查询相应办理入口及链接
     *
     * @return 结果
     */
    public List<BsBlrk> selectBsBlrkById(Long id);

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
    public int insertBsBlrk(List<BsBlrk> bsBlrk);
}
