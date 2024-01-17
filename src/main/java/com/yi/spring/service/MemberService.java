package com.yi.spring.service;

import com.yi.spring.vo.MemberVO;

import java.util.List;

public interface MemberService {

    public List<MemberVO> listMembers();
    public void userAdd(MemberVO vo);
}
