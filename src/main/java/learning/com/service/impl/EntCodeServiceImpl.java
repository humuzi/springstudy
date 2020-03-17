package learning.com.service.impl;

import learning.com.mybatis.mapper.EntCodeMapper;
import learning.com.service.EntCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/3/13
 */
@Service
@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
public class EntCodeServiceImpl implements EntCodeService {

    @Autowired  private EntCodeMapper entCodeMapper;

    public List getEntCode(){
        return  entCodeMapper.selectEntCode();

    }
}
