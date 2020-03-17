package learning.com.service.impl;

import learning.com.service.RedisRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;

import javax.sql.DataSource;

/**
 * Create by HuQiuYue on 2019-11-25
 */
public class RedisRedPacketServiceImpl implements RedisRedPacketService {

    private static final String PREFIX = "red_packet_list_";
    private static final int TIME_SIZE = 1000;

    @Autowired private RedisTemplate redisTemplate;
    @Autowired private DataSource dataSource;

    @Override
    @Async
    public void saveRedPacketByRedis(Long redPacketId, Double unitAmount) {
        Long start = System.currentTimeMillis();
        BoundListOperations ops = redisTemplate.boundListOps(redPacketId);
        Long size = ops.size();
    }
}
