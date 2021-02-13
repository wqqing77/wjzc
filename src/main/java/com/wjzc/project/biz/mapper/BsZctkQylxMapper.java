package com.wjzc.project.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjzc.project.biz.domain.BsZctkQylx;

import java.util.List;
import java.util.Map;

public interface BsZctkQylxMapper extends BaseMapper<BsZctkQylx> {


    /**
     * 新增政策条款
     * @author wjzc
     */
    public int insertZctkQylx(BsZctkQylx zctkQylx);


    /**
     * 通过条款ID删除条款
     *
     * @return 结果
     */
    public int deleteWjzcQylxById(Long zctkId);


    public BsZctkQylx selectBsZctkQylxById(Long zctkId);

    /**
     * 通过条款ID查询相应企业类型
     *
     * @return 结果
     */
    public List<BsZctkQylx> selectBsZctkQylxByZctkId(Long zctkId);
}
