package com.wjzc.project.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjzc.project.biz.domain.BsAreaZctk;
import com.wjzc.project.biz.domain.BsZctk;
import com.wjzc.project.biz.domain.BsZctkQylx;
import com.wjzc.project.biz.mapper.BsAreaZctkMapper;
import com.wjzc.project.biz.mapper.BsZctkMapper;
import com.wjzc.project.biz.mapper.BsZctkQylxMapper;
import com.wjzc.project.biz.mapper.SysAreaZctkMapper;
import com.wjzc.project.biz.service.IBsZctkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户 业务层处理
 *
 * @author wjzc
 */
@Service
public class BsZctkServiceImpl extends ServiceImpl<BsZctkMapper, BsZctk> implements IBsZctkService {

    private static final Logger log = LoggerFactory.getLogger(BsZctkServiceImpl.class);

    @Autowired
    private BsZctkMapper bsZctkMapper;

    @Autowired
    private BsZctkQylxMapper bsZctkQylxMapper;

    @Autowired
    private BsAreaZctkMapper bsAreaZctkMapper;


    @Override
    public BsZctk selectZctkById(Long id) {
        return bsZctkMapper.selectZctkById(id);
    }


    /**
     * 获取政策条款列表
     */
    public List<BsZctk> selectBsZctkList(BsZctk zctk) {
        return bsZctkMapper.selectBsZctkList(zctk);
    }

    /**
     * 获取政策条款量
     */
    public Integer selectBsZctkNum() {
        return bsZctkMapper.selectBsZctkNum();
    }


    /**
     * 新增政策条款信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertZctk(BsZctk zctk) {
        // 新增政策条款信息
        int row = bsZctkMapper.insertZctk(zctk);
        Long newId = bsZctkMapper.selectBsZctkMaxId().getId();
        saveQylx(newId,zctk.getQylxCode());
        savedq(newId,zctk.getSxqCode());
        return row;
    }

    /**
     * 查询条款信息中最大的id值
     *
     * @return 结果
     */
    @Override
    public BsZctk selectBsZctkMaxId(){
        return bsZctkMapper.selectBsZctkMaxId();
    }

    /**
     * 删除条款信息
     *
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteWjzcById(Long id) {
        bsZctkQylxMapper.deleteWjzcQylxById(id);
        bsAreaZctkMapper.deleteSysAreaZctkById(id);
        return bsZctkMapper.deleteWjzcById(id);
    }

    /**
     * 查询条款信息
     *
     * @return 结果
     */
    @Override
    public BsZctk selectBsZctkById(Long id) {
        List<String> qylxCodes = new ArrayList<>();
        List<String> dqCodes = new ArrayList<>();
        List<BsZctkQylx> bsQylx = bsZctkQylxMapper.selectBsZctkQylxByZctkId(id);
        List<BsAreaZctk> dq = bsAreaZctkMapper.selectSysAreaZctkById(id);
        for(int i=0;i<bsQylx.size();i++){
            qylxCodes.add(bsQylx.get(i).getQylx());
        }
        for(int i=0;i<dq.size();i++){
            dqCodes.add(dq.get(i).getCityname());
        }
        BsZctk bz = bsZctkMapper.selectBsZctkById(id);
        bz.setQylxCode(qylxCodes);
        bz.setSxqCode(dqCodes);
        return bz;
    }

    /**
     * 修改条款信息
     *
     * @return 结果
     */
    @Override
    @Transactional
    public int updateWjzc(BsZctk zctk) {
        //查询出对应的政策条款id
        long zctkId = zctk.getId();
        //删除相对应的企业类型
        bsZctkQylxMapper.deleteWjzcQylxById(zctkId);
        //删除相对应的地区
        bsAreaZctkMapper.deleteSysAreaZctkById(zctkId);
        //新增修改后的企业类型
        saveQylx(zctkId,zctk.getQylxCode());
        //新增修改后的地区
        savedq(zctkId,zctk.getSxqCode());
        return bsZctkMapper.updateWjzc(zctk);
    }

    /**
     * 查询五减类型占比
     * @author wjzc
     */
    public List<Map<String,Object>> selectBsZctkRaddarList() {
        return bsZctkMapper.selectBsZctkRaddarList();
    }

    /**
     * 查询五减类型点击量对比
     * @author wjzc
     */
    public Map<String,Object> selectBsZctkBarList() {
        Map<String,Object> m = new HashMap<>();
        List<Map<String,Object>> list = bsZctkMapper.selectBsZctkBarList();

        List<String> xdata = new ArrayList<>();
        List ydata = new ArrayList();
        for(int i=0;i<list.size();i++){
            Map<String,Object> map = list.get(i);
            if(!xdata.contains(map.get("zctknumtime"))){
                xdata.add(map.get("zctknumtime").toString());
            }
        }
        for(int j=0;j<xdata.size();j++){
            List<Integer> ylist = new ArrayList<>();
            int s1 = 0,s2 = 0,s3 = 0,s4 = 0,s5 = 0,s6 = 0;
            String str = xdata.get(j);
            for(int i=0;i<list.size();i++){
                Map<String,Object> map = list.get(i);

                if(map.get("zctknumtime").equals(str) && "减息".equals(map.get("wjlx"))){
                    s1 = Integer.parseInt(map.get("zctknum").toString());
                }
                if(map.get("zctknumtime").equals(str) && "减税".equals(map.get("wjlx"))){
                    s2 = Integer.parseInt(map.get("zctknum").toString());
                }
                if(map.get("zctknumtime").equals(str) && "减费".equals(map.get("wjlx"))){
                    s3 = Integer.parseInt(map.get("zctknum").toString());
                }
                if(map.get("zctknumtime").equals(str) && "减租".equals(map.get("wjlx"))){
                    s4 = Integer.parseInt(map.get("zctknum").toString());
                }
                if(map.get("zctknumtime").equals(str) && "减支".equals(map.get("wjlx"))){
                    s5 = Integer.parseInt(map.get("zctknum").toString());
                }
                if(map.get("zctknumtime").equals(str) && "其他".equals(map.get("wjlx"))){
                    s6 = Integer.parseInt(map.get("zctknum").toString());
                }
            }
            ylist.add(s1);
            ylist.add(s2);
            ylist.add(s3);
            ylist.add(s4);
            ylist.add(s5);
            ylist.add(s6);
            ydata.add(ylist);
        }
        m.put("xdata",xdata);
        m.put("ydata",ydata);
        return m;
    }

    /**
     * 查询政策类型点击量对比
     * @author wjzc
     */
    public List<Map<String,Object>> selectBsZctkPieList() {
        return bsZctkMapper.selectBsZctkPieList();
    }

    @Override
    public List<Map<String,Object>> selectZctkList(Map<String, Object> map) {
        return bsZctkMapper.selectZctkList(map);
    }

    @Override
    public List<Map<String,Object>> selectZctkList2(Map<String, Object> map) {
        return bsZctkMapper.selectZctkList2(map);
    }

    @Override
    public List<Map<String, Object>> selectZclxByQylx(Map<String, Object> map) {
        return bsZctkMapper.selectZclxByQylx(map);
    }

    @Override
    public List<Map<String, Object>> selectZclxByQylx2(String qylx) {
        return bsZctkMapper.selectZclxByQylx2(qylx);
    }

    @Override
    public List<Map<String, Object>> selectByWjlxAndZctk(Map<String, Object> map) {
        return bsZctkMapper.selectByWjlxAndZctk(map);
    }

    @Override
    public List<Map<String, Object>> selectByQylxAndZctk(Map<String, Object> map) {
        return bsZctkMapper.selectByQylxAndZctk(map);
    }

    @Override
    public List<Map<String, Object>> search(String keyWord) {
        return bsZctkMapper.search(keyWord);
    }

    @Override
    public List<Map<String, Object>> search2(Map<String, Object> map) {
        return bsZctkMapper.search2(map);
    }

    public void saveQylx(Long dictId,List<String> qylx){

        for(int i=0;i<qylx.size();i++){
            String arr = qylx.get(i);
            String arrcode = arr.split("-")[0];
            String arrqylx = arr.split("-")[1];
            BsZctkQylx lx = new BsZctkQylx();
            lx.setZctkId(dictId);
            lx.setQylxCode(arrcode);
            lx.setQylx(arrqylx);
            bsZctkQylxMapper.insertZctkQylx(lx);
        }
    }

    public void savedq(Long dictId,List<String> dq){

        for(int i=0;i<dq.size();i++){
            String arr = dq.get(i);
            String arrCode = arr.split("-")[0];
            String arrName = arr.split("-")[1];
            BsAreaZctk lx = new BsAreaZctk();
            lx.setZctkId(dictId);
            lx.setAreaCode(arrCode);
            lx.setAreaName(arrName);
           // lx.setQylx(arrqylx);
            bsAreaZctkMapper.insertSysAreaZctk(lx);
        }
    }
}
