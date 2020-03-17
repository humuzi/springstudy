package learning.com.service.impl;

import learning.com.mybatis.mapper.RedPacketMapper;
import learning.com.mybatis.mapper.UserRedPacketMapper;
import learning.com.pojo.RedPacket;
import learning.com.pojo.UserRedPacket;
import learning.com.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by HuQiuYue on 2019-11-18
 */
public class UserRedPacketServiceImpl implements UserRedPacketService {

    @Autowired private RedPacketMapper redPacketMapper;
    @Autowired private UserRedPacketMapper userRedPacketMapper;

    private static final  int FAILED = 0;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int grapRedPacket(Long redPacketId,Long userId) {
        RedPacket redPacket = redPacketMapper.getRedPacket(redPacketId);

        if(redPacket.getStock() > 0){
            redPacketMapper.decreaseRedPacket(redPacketId);
            UserRedPacket userRedPacket = new UserRedPacket();
            userRedPacket.setRedPacketId(redPacketId);
            userRedPacket.setUserId(userId);
            userRedPacket.setAmount(redPacket.getUnitAmount());
            userRedPacket.setNote("红包" + redPacketId);

            int result = userRedPacketMapper.grapredPacket(userRedPacket);
            return result;
        }
        return FAILED;
    }


    @Override
    public int grapRedPacketForVersion(Long redPacketId, Long userId) {

        long start = System.currentTimeMillis();
        while(true){
            long end = System.currentTimeMillis();
            if(end - start > 100)
                return FAILED;

            RedPacket redPacket = redPacketMapper.getRedPacket(redPacketId);

            if(redPacket.getStock() > 0){
                int update  = redPacketMapper.decreaseRedpacketForVersion(redPacketId,redPacket.getVersion());
                if(update == 0)
                    return FAILED;

                UserRedPacket userRedPacket = new UserRedPacket();
                userRedPacket.setNote("红包" + redPacketId);
                userRedPacket.setRedPacketId(redPacketId);
                userRedPacket.setUserId(userId);
                userRedPacket.setAmount(redPacket.getAmount());

                int result = userRedPacketMapper.grapredPacket(userRedPacket);
                return result;
            }

            else{
                return FAILED;
            }
        }

    }
}
