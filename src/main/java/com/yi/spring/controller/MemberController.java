package com.yi.spring.controller;

import com.yi.spring.service.MemberService;
import com.yi.spring.vo.MemberVO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@ComponentScan
@RequestMapping("/member/*")
public class MemberController {

    @Autowired
    private MemberService memberService;
    private static final String namespace = "mappers.MemberMapper.";

    @GetMapping("/userAdd")
    public String userAddForm(MemberVO vo, Model model) throws Exception{

        return "member/listForm";
    }

    @PostMapping("/userAdd")
    public String userAdd(MemberVO vo, Model model) throws Exception{

        System.out.println("111->"+ vo.getUserId());
        System.out.println(vo.getUserName());
        System.out.println(vo.getUserPassword());
        memberService.userAdd(vo);

        return "redirect:member/userList";
    }

    @GetMapping("/userList")
    public String userList(MemberVO vo, Model model) throws Exception{

        List<MemberVO> list = memberService.listMembers();

        System.out.println(list);
        model.addAttribute("list", list);
        return "member/list";
    }

}
