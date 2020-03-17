package learning.com.mybatis.mapper;

import learning.com.pojo.UserRedPacket;
import org.springframework.stereotype.Repository;

/**
 * Create by HuQiuYue on 2019-11-18
 */
@Repository
public interface UserRedPacketMapper {
    int grapredPacket(UserRedPacket userRedPacket);
}
