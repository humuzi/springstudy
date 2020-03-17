package learning.com.service;

import learning.com.pojo.UserRedPacket;

/**
 * Create by HuQiuYue on 2019-11-18
 */
public interface UserRedPacketService {
    int grapRedPacket(Long redPacketId,Long userId);
    int grapRedPacketForVersion(Long redPacketId,Long userId);
}
