package com.yi.spring.service;

import com.yi.spring.exception.ErrorResponse;
import com.yi.spring.exception.InsufficientBalanceException;
import com.yi.spring.mappers.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;


    @Transactional(rollbackFor = InsufficientBalanceException.class)
    @Override
    public void sendMoney() throws InsufficientBalanceException {

            accountMapper.updateBalance1();
            if(getBalance("70-490-911") < 0){
                throw new InsufficientBalanceException("잔액이 부족합니다.");
            }
            accountMapper.updateBalance2();
    }

    @ExceptionHandler(value=InsufficientBalanceException.class)
    public ResponseEntity<ErrorResponse> handleInsufficientBalanceException(InsufficientBalanceException e) {
        // 예외 처리 코드
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("USER_NOT_FOUND");
        errorResponse.setMessage("사용자를 찾을 수 없습니다.");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }


    @Override
    public double getBalance(String accountNumber) {
        return accountMapper.getBalance(accountNumber);
    }

}
