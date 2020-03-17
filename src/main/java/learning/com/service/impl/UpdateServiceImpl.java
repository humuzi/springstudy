package learning.com.service.impl;

import learning.com.mybatis.mapper.RoleMapper;
import learning.com.pojo.Role;
import learning.com.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by HuQiuYue on 2019-08-28
 */
@Service
public class UpdateServiceImpl implements UpdateService {
    @Autowired private RoleMapper roleMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @CachePut(value = "redisCacheManager",key=" 'role_' + #role.id")
    public int updateTelNo(Role role){
        roleMapper.updateById(role);
        return 0;
    }
}
