package learning.com.service;

import org.apache.ibatis.annotations.Param;

/**
 * Create by HuQiuYue on 2019-08-29
 */
public interface DeleteService {

    int deleteByName(@Param("name") String name);
}
