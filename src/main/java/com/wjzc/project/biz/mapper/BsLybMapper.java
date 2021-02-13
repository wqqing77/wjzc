package com.wjzc.project.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjzc.project.biz.domain.BsLyb;

import java.util.List;

public interface BsLybMapper extends BaseMapper<BsLyb> {

    /**
     * 查询留言板列表
     * @author wjzc
     */
    public List<BsLyb> selectBsLybList(BsLyb lyb);

    /**
     * ID删除留言内容
     *
     * @return 结果
     */
    public int deleteBsLybById(Long id);

    /**
     * 留言板数量
     * @author wjzc
     */
    public Integer selectBsLybNum();
}
