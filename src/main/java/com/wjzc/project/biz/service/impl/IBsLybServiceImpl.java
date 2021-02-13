package com.wjzc.project.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjzc.project.biz.domain.BsLyb;
import com.wjzc.project.biz.domain.BsZctk;
import com.wjzc.project.biz.mapper.BsLybMapper;
import com.wjzc.project.biz.service.IBsLybService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBsLybServiceImpl extends ServiceImpl<BsLybMapper, BsLyb>  implements IBsLybService {
    @Autowired
    private BsLybMapper bsLybMapper;

    /**
     * 获取留言板列表
     */
    public List<BsLyb> selectBsLybList(BsLyb lyb) {
        return bsLybMapper.selectBsLybList(lyb);
    }

    /**
     * 删除留言板信息
     *
     * @return 结果
     */
    @Override
    public int deleteBsLybById(Long id) {
        return bsLybMapper.deleteBsLybById(id);
    }

    /**
     * 获取留言板数量
     */
    public Integer selectBsLybNum() {
        return bsLybMapper.selectBsLybNum();
    }

    public void insertMessage(String name,String phone,String content,Integer anonymous){
        BsLyb bsLyb = new BsLyb();
        bsLyb.setName(name);
        bsLyb.setAnonymous(anonymous);
        bsLyb.setContent(content);
        bsLyb.setPhone(phone);
        bsLybMapper.insert(bsLyb);
    }
}
