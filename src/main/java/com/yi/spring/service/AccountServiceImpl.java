package com.yi.spring.service;

import com.yi.spring.exception.ErrorResponse;
import com.yi.spring.exception.InsufficientBalanceException;
import com.yi.spring.mappers.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;


    @Transactional(rollbackFor = UnexpectedRollbackException.class)
    @Override
    public void sendMoney() {

        try{
            accountMapper.updateBalance1();
            if(getBalance("70-490-911") < 0){
                throw new UnexpectedRollbackException("잔액이 부족합니다.");
            }
            accountMapper.updateBalance2();
        }catch (UnexpectedRollbackException e){
            handleInsufficientBalanceException(e);
        }
    }
    @Override
    public double getBalance(String accountNumber) {
        return accountMapper.getBalance(accountNumber);
    }

    @ExceptionHandler(UnexpectedRollbackException.class)
    @Override
    public ResponseEntity<ErrorResponse> handleInsufficientBalanceException(UnexpectedRollbackException e) {
        System.out.println("233333333333333333333");
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("UNEXPECTED_ROLLBACK");
        errorResponse.setMessage("예기치 않은 롤백이 발생했습니다.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }




}
