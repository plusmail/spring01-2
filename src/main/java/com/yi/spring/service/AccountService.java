package com.yi.spring.service;

public interface AccountService {

    void sendMoney() throws Exception;
    double getBalance(String accountNumber);

}
