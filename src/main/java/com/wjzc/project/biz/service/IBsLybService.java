package com.wjzc.project.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wjzc.project.biz.domain.BsLyb;

import java.util.List;

/**
 * @author wjzc
 */
public interface IBsLybService extends IService<BsLyb> {


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

    public void insertMessage(String name,String phone,String content,Integer anonymous);

    /**
     * 留言板数量
     * @author wjzc
     */
    public Integer selectBsLybNum();

}
