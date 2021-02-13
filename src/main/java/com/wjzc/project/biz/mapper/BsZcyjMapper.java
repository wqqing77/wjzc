package com.wjzc.project.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjzc.project.biz.domain.BsBlrk;
import com.wjzc.project.biz.domain.BsZcyj;

import java.util.List;

public interface BsZcyjMapper extends BaseMapper<BsZcyj> {


    /**
     * 新增政策发布及链接
     * @author wjzc
     */
    public int insertBsZcyj(BsZcyj bsZcyj);


    /**
     * 通过条款ID删除政策发布及链接
     *
     * @return 结果
     */
    public int deleteBsZcyjById(Long id);

    /**
     * 通过条款ID查询相应政策发布及链接
     *
     * @return 结果
     */
    public List<BsZcyj> selectBsZcyjById(Long id);
}
