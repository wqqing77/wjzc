package com.wjzc.project.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjzc.project.biz.domain.BsAreaZctk;
import com.wjzc.project.biz.domain.BsBlrk;

import java.util.List;

public interface BsBlrkMapper extends BaseMapper<BsBlrk> {


    /**
     * 新增办理入口及链接
     * @author wjzc
     */
    public int insertBsBlrk(BsBlrk bsBlrk);


    /**
     * 通过条款ID删除办理入口及链接
     *
     * @return 结果
     */
    public int deleteBsBlrksById(Long id);

    /**
     * 通过条款ID查询相应办理入口及链接
     *
     * @return 结果
     */
    public List<BsBlrk> selectBsBlrkById(Long id);
}
