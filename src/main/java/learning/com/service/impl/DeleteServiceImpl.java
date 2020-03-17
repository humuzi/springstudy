package learning.com.service.impl;

import learning.com.mybatis.mapper.RoleMapper;
import learning.com.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by HuQiuYue on 2019-08-29
 */

@Service
public class DeleteServiceImpl implements DeleteService {

    @Autowired private RoleMapper roleMapper;

    @Override
    @Transactional
    public int deleteByName(String name){
        roleMapper.deleteByName(name);
        return 0;
    }
}
