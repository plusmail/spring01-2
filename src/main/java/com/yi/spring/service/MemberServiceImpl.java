package com.yi.spring.service;

import com.yi.spring.dao.MemberDAO;
import com.yi.spring.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDAO memberDAO;

    public void setMemberDAO(MemberDAO memberDAO){
        this.memberDAO = memberDAO;
    }

    @Override
    public List<MemberVO> listMembers() {
        List<MemberVO> membersList = null;
        membersList = memberDAO.listMembers();
        return membersList;
    }

    @Override
    public void userAdd(MemberVO vo) {
        memberDAO.userAdd(vo);
    }
}
