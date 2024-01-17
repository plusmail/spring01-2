package com.yi.spring.controller;


import com.yi.spring.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    @GetMapping("/userAdd")
    public String userAddForm(MemberVO vo, Model model) throws Exception{

        return "member/listForm";
    }

    @PostMapping("/userAdd")
    public String userAdd(MemberVO vo, Model model) throws Exception{


        return "member/list";
    }


}
