package learning.com.service;

import learning.com.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Create by HuQiuYue on 2019-08-14
 */
public interface RoleService {
    Role insertRoleMembers(Role role);
    Role  selectOne(@Param("userName") String userName);
    List<Role> selectRoles(@Param("name")String name,@Param("mobile")String mobile);
}
