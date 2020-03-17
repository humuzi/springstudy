package learning.com.mybatis.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/3/13
 */
@Repository
public interface EntCodeMapper {
    List  selectEntCode();
}
