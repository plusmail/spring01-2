package com.yi.spring.controller;

import com.yi.spring.exception.ErrorResponse;
import com.yi.spring.exception.InsufficientBalanceException;
import com.yi.spring.service.AccountService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Setter
@Controller
@ComponentScan
@RestController
@RequestMapping("/account/*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String index(Model model){

        return "/account/index";
    }

    @GetMapping("/balance")
    @Transactional
    @ResponseBody
    public ResponseEntity<ErrorResponse> sendMoney(Model model) {

        try{
            accountService.sendMoney();
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setCode("11111");
            errorResponse.setMessage("송금성공");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

        }catch (UnexpectedRollbackException e){
            System.out.println("2222222222222222222222");
            e.printStackTrace();
            return accountService.handleInsufficientBalanceException(e);
        }

    }


}


//{
//        "code": "001",
//        "message": "잔액이 부족합ㄴ."
//}