package com.yi.spring.controller;

import com.yi.spring.exception.ErrorResponse;
import com.yi.spring.exception.InsufficientBalanceException;
import com.yi.spring.service.AccountService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Setter
@Controller
@RestController
@RequestMapping("/account/*")
@ControllerAdvice
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/balance")
    @Transactional
    @ResponseBody
    public String sendMoney(Model model) {

        try{
            accountService.sendMoney();

        }catch (InsufficientBalanceException e){
            e.printStackTrace();
        }

        return "/account/list";
    }

    @ExceptionHandler(value=InsufficientBalanceException.class)
    public ResponseEntity<ErrorResponse> handleInsufficientBalanceException(Exception e) {
        // 예외 처리 코드
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("001");
        errorResponse.setMessage("잔액이 부족합ㄴ.");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

}


//{
//        "code": "001",
//        "message": "잔액이 부족합ㄴ."
//}