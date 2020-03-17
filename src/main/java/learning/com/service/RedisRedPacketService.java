package learning.com.service;

/**
 * Create by HuQiuYue on 2019-11-23
 */
public interface RedisRedPacketService {
    void saveRedPacketByRedis(Long redPacketId,Double unitAmount);
}
