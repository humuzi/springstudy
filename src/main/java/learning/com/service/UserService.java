package learning.com.service;

import learning.com.pojo.User;

import java.util.List;

/**
 * Create by HuQiuYue on 2019-11-13
 */
public interface UserService {
    User findById(long id);
    void  saveUser(User user);
    void updateUser(User user);
    void deleteUserById(long id);
    List<User> findAllUsers();
    void deleteAllUsers();
}
