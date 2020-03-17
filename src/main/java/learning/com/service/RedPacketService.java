package learning.com.service;

import learning.com.pojo.RedPacket;

/**
 * Create by HuQiuYue on 2019-11-18
 */
public interface RedPacketService {
    RedPacket getRedPacket(Long id);
    int decreaseRedPacket(Long id);
}
