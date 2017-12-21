package com.xylem.dewatering.fst.service.impl;

import com.xylem.dewatering.fst.entity.Account;
import com.xylem.dewatering.fst.repository.AccountRepository;
import com.xylem.dewatering.fst.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Anoop.ks on 19-12-2017
 */

@Service
public class AccountServiceImpl implements AccountService {

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account saveAccount(Account account) {
        logger.info("Inside Service method.");
        return accountRepository.save(account);
    }
}
