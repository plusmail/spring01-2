package com.yi.spring.mappers;

import com.yi.spring.vo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findById(Long id);

    void save(User user);
}