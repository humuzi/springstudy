package learning.com.service.impl;

import learning.com.mybatis.mapper.RedPacketMapper;
import learning.com.pojo.RedPacket;
import learning.com.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by HuQiuYue on 2019-11-18
 */
@Service
public class RedPacketServiceImpl implements RedPacketService {

    @Autowired private RedPacketMapper redPacketMapper = null;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public RedPacket getRedPacket(Long id){
        return redPacketMapper.getRedPacket(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int decreaseRedPacket(Long id){
        return redPacketMapper.decreaseRedPacket(id);
    }

}
