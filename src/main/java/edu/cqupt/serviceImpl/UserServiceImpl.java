package edu.cqupt.serviceImpl;

import edu.cqupt.domain.User;
import edu.cqupt.mapper.UserMapper;
import edu.cqupt.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by aa on 2017/8/2.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
  @Resource
  private UserMapper userMapper;

  //判断登录密码是否正确
    public boolean checkUser(User user) {

            return false;
    }

    public boolean existUser(String username) {
        return true;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public void updateImageById(User user) {

    }
}
