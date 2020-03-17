package learning.com.service.impl;

import learning.com.pojo.User;
import learning.com.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Create by HuQiuYue on 2019-11-14
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
    private static List<User> users;

    @Override
    public User findById(long id){
        for(User user: users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    @Override
    public List<User> findAllUsers(){
        return users;
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.add(index,user);
    }

    @Override
    public void deleteUserById(long id) {
        for(Iterator<User> iterator = users.iterator();iterator.hasNext();){
            User user = iterator.next();
            if(user.getId() == id)
                iterator.remove();
        }
    }

    @Override
    public void deleteAllUsers() {
        users.clear();
    }
}
