package com.yi.spring.dao;

import com.yi.spring.vo.MemberVO;

import java.util.List;

public interface MemberDAO {
    public List<MemberVO> listMembers();
    public void userAdd(MemberVO vo);
}
