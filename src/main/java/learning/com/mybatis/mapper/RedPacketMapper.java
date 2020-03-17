package learning.com.mybatis.mapper;

import learning.com.pojo.RedPacket;

/**
 * Create by HuQiuYue on 2019-11-18
 */
public interface RedPacketMapper {
    RedPacket getRedPacket(Long id);
    int decreaseRedPacket(Long id);
    int decreaseRedpacketForVersion(Long id,int version);
}
