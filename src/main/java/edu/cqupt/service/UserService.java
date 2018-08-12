package edu.cqupt.service;

import edu.cqupt.domain.User;

/**
 * Created by hg on 2018/2/11.
 */
public interface UserService {
    /**
     * 用户登陆校验
     * @param username
     * @param password
     * @return
     */
     User login(String username,String password);

    public void updateImageById(User user);

}
