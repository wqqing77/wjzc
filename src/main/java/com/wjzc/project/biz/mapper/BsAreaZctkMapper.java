package com.wjzc.project.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjzc.project.biz.domain.BsAreaZctk;
import com.wjzc.project.biz.domain.BsZctkQylx;
import com.wjzc.project.biz.domain.SysAreaZctk;

import java.util.List;

public interface BsAreaZctkMapper extends BaseMapper<BsAreaZctk> {


    /**
     * 新增政策条款地区
     * @author wjzc
     */
    public int insertSysAreaZctk(BsAreaZctk areaZctk);


    /**
     * 通过条款ID删除条款
     *
     * @return 结果
     */
    public int deleteSysAreaZctkById(Long zctkId);


    //public BsZctkQylx selectBsZctkQylxById(Long zctkId);

    /**
     * 通过条款ID查询相应企业类型
     *
     * @return 结果
     */
    public List<BsAreaZctk> selectSysAreaZctkById(Long zctkId);
}
