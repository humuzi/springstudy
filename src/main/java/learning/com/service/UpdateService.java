package learning.com.service;

import learning.com.pojo.Role;
import org.apache.ibatis.annotations.Param;

/**
 * Create by HuQiuYue on 2019-08-28
 */
public interface UpdateService {
   int updateTelNo(Role role);
}
