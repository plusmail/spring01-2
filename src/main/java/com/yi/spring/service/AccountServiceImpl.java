package com.yi.spring.service;

import com.yi.spring.mappers.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void sendMoney() throws Exception {

            accountMapper.updateBalance1();
            if(getBalance("70-490-911") < 0){
                throw new Exception("잔액이 부족합니다.");
            }
            accountMapper.updateBalance2();
    }

    @Override
    public double getBalance(String accountNumber) {
        return accountMapper.getBalance(accountNumber);
    }
}
