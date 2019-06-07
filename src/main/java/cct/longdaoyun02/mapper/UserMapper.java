package cct.longdaoyun02.mapper;

import cct.longdaoyun02.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsername(String username);
}
