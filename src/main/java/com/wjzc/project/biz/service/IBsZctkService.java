package com.wjzc.project.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wjzc.project.biz.domain.BsZctk;

import java.util.List;
import java.util.Map;

/**
 * @author wjzc
 */
public interface IBsZctkService extends IService<BsZctk> {


    public BsZctk selectZctkById(Long id);

    /**
     * 查询政策条款列表
     * @author wjzc
     */
    public List<BsZctk> selectBsZctkList(BsZctk zctk);


    /**
     * 政策条款数量
     * @author wjzc
     */
    public Integer selectBsZctkNum();

    /**
     * 新增政策条款
     * @author wjzc
     */
    public int insertZctk(BsZctk zctk);

    /**
     * 通过条款ID删除条款
     *
     * @return 结果
     */
    public int deleteWjzcById(Long id);

    /**
     * 查询详细条款
     *
     * @return 结果
     */
    public BsZctk selectBsZctkById(Long id);

    /**
     * 修改条款信息
     *
     * @return 结果
     */
    public int updateWjzc(BsZctk zctk);

    /**
     * 查询政策条款中id值最大的
     *
     * @return 结果
     */
    public BsZctk selectBsZctkMaxId();

    /**
     * 查询五减类型占比
     * @author wjzc
     */
    public List<Map<String,Object>> selectBsZctkRaddarList();

    /**
     * 查询五减类型点击量对比
     * @author wjzc
     */
    public Map<String,Object> selectBsZctkBarList();

    /**
     * 查询政策类型点击量对比
     * @author wjzc
     */
    public List<Map<String,Object>> selectBsZctkPieList();

    public List<Map<String,Object>> selectZctkList(Map<String,Object> map);

    public List<Map<String,Object>> selectZctkList2(Map<String,Object> map);

    public List<Map<String,Object>> selectZclxByQylx(Map<String, Object> map);

    public List<Map<String,Object>> selectZclxByQylx2(String qylx);

    public List<Map<String,Object>> selectByWjlxAndZctk(Map<String,Object> map);

    public List<Map<String,Object>> selectByQylxAndZctk(Map<String,Object> map);

    public List<Map<String,Object>> search(String keyWord);

    public List<Map<String,Object>> search2(Map<String,Object> map);

}
