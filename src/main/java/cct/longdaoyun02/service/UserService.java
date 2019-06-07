package cct.longdaoyun02.service;

import cct.longdaoyun02.entity.User;
import cct.longdaoyun02.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findByUsername(String username){
        return userMapper.findByUsername(username);

    }

}
