package com.yi.spring.service;

import com.yi.spring.exception.ErrorResponse;
import com.yi.spring.exception.InsufficientBalanceException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface AccountService {

    void sendMoney() throws InsufficientBalanceException;
    double getBalance(String accountNumber);

//    @ExceptionHandler(value=UnexpectedRollbackException.class)
//    ResponseEntity<ErrorResponse> handleInsufficientBalanceException(UnexpectedRollbackException e);

}
