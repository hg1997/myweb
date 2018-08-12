package edu.cqupt.mapper;

import edu.cqupt.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //==================

    User login(User user);

    void updateImageById(User user);

}