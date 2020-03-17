package learning.com.mybatis.mapper;

import learning.com.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by HuQiuYue on 2019-08-12
 */
@Repository
public interface RoleMapper {

    int insertRole(Role role);
    Role selectByName(@Param("userName")String userName);
    List<Role> selectRoles(@Param("name") String name,@Param("mobile") String mobile);
    int updateById(Role role);
    void updateByConditions(@Param("name") String name, @Param("phone") String phone);
    int deleteByName(@Param("name") String name);
    void deleteByConditions(String name);


}
