package com.yi.spring.mappers;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface AccountMapper {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    void updateBalance1();
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    void updateBalance2();

    double getBalance(String accountNumber);
}
