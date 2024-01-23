package com.yi.spring.mappers;

import com.yi.spring.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {

    public List<MemberVO> listMembers();
    public void  userAdd(@Param("vo") MemberVO vo);
}
