package learning.com.service.impl;

import learning.com.mybatis.mapper.RoleMapper;
import learning.com.pojo.Role;
import learning.com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create by HuQiuYue on 2019-08-13
 */

@Service
@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper = null;


    @Override
    @CachePut(value = "redisCacheManager",key = "'role_' + #result.id")
    public Role insertRoleMembers(Role role){
       roleMapper.insertRole(role);
       return role;
    }

    @Override
    @Cacheable(value = "redisCacheManager",key = "'role_' + #result.username")
    public Role selectOne(String userName){
        Role role = roleMapper.selectByName(userName);
        System.out.println(role);
        return role;
    }


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public List<Role> selectRoles(String name,String mobile){
        List<Role> roles = roleMapper.selectRoles(name,mobile);
        System.out.println(roles);
        return roles;
    }
}
