package com.wjzc.project.system.service;

import java.util.List;

import com.wjzc.project.system.domain.SysDictData;

/**
 * 字典 业务层
 *
 * @author wjzc
 */
public interface ISysDictDataService {
    /**
     * 根据条件分页查询字典数据
     *
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    public List<SysDictData> selectDictDataList(SysDictData dictData);

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    public List<SysDictData> selectDictDataByType(String dictType);

    /**
     * 查询五减类型
     *
     * 查询五减类型信息
     */
    public List<SysDictData> selectDictDataByTypeWjlx(SysDictData dictData);

    /**
     * 查询政策类型
     *
     * 查询政策类型信息
     */
    public List<SysDictData> selectDictDataByTypeZclx(SysDictData dictData);

    /**
     * 查询金华地区（搜索单选）
     *
     * @return 查询金华地区（搜索单选）
     */
    public List<SysDictData> selectDictDataByTypeDq(SysDictData dictData);

    /**
     * 查询企业类型
     *
     * 查询企业类型信息
     */
    public List<SysDictData> selectDictDataByTypeQylx(SysDictData dictData);

    /**
     * 查询金华各地区
     *
     * @return 查询金华各地区
     */
    public List<SysDictData> selectDictDataByTypeArea(SysDictData dictData);

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String selectDictLabel(String dictType, String dictValue);

    /**
     * 根据字典数据ID查询信息
     *
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    public SysDictData selectDictDataById(Long dictCode);

    /**
     * 通过字典ID删除字典数据信息
     *
     * @param dictCode 字典数据ID
     * @return 结果
     */
    public int deleteDictDataById(Long dictCode);

    /**
     * 批量删除字典数据信息
     *
     * @param dictCodes 需要删除的字典数据ID
     * @return 结果
     */
    public int deleteDictDataByIds(Long[] dictCodes);

    /**
     * 新增保存字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 结果
     */
    public int insertDictData(SysDictData dictData);

    /**
     * 修改保存字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 结果
     */
    public int updateDictData(SysDictData dictData);
}
