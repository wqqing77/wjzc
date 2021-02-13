package com.wjzc.project.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wjzc.project.biz.domain.BsZctkQylx;

import java.util.List;
import java.util.Map;

/**
 * @author wjzc
 */
public interface IBsZctkQylxService extends IService<BsZctkQylx> {

    /**
     * 新增政策条款
     * @author wjzc
     */
    public int insertZctkQylx(BsZctkQylx zctkQylx);


    /**
     * 通过条款ID删除对应企业类型
     *
     * @return 结果
     */
    public int deleteWjzcQylxById(Long zctkId);
}
