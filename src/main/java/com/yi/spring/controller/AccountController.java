package com.yi.spring.controller;

import com.yi.spring.exception.InsufficientBalanceException;
import com.yi.spring.service.AccountService;
import com.yi.spring.service.UserService;
import com.yi.spring.vo.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Setter
@Controller
@ComponentScan
@ControllerAdvice
@RequestMapping("/account/*")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){

        return "/account/index";
    }

    @GetMapping("/balance")
    @Transactional
    @ResponseBody
    public void sendMoney(Model model) throws InsufficientBalanceException {

//        User user = userService.findUserById(1L);
            accountService.sendMoney();

            return;
    }

}
