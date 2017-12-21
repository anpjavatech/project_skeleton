package com.xylem.dewatering.fst.unitTest.testService;

import com.xylem.dewatering.fst.entity.Account;
import com.xylem.dewatering.fst.entity.embeddable.AccountAddress;
import com.xylem.dewatering.fst.repository.AccountRepository;
import com.xylem.dewatering.fst.service.AccountService;
import com.xylem.dewatering.fst.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Anoop.ks on 19-12-2017
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AccountServiceTest {


    @TestConfiguration
    static class AccountServiceImplTestConfiguration {

        @Bean
        public AccountService accountService() {
            return new AccountServiceImpl();
        }
    }

    @Autowired
    AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @Before
    public void setUp() {
        Account account = new Account("Anoop", "8971983387", "Active", "anoop.ks007@gmail.com",
                "Bangalore", "jhgkhjh", new AccountAddress("hbkj", "kjklk",
                "kjnj", "lkljkk", "lkljk", "lkmkk"));

        Mockito.when(accountRepository.save(account)).thenReturn(account);
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account("Anoop", "8971983387", "Active", "anoop.ks007@gmail.com",
                "Bangalore", "jhgkhjh", new AccountAddress("hbkj", "kjklk",
                "kjnj", "lkljkk", "lkljk", "lkmkk"));

        Account responseAccount = accountService.saveAccount(account);
        System.out.println("id :: " + responseAccount.getId());
        assertThat(responseAccount.getId(), is(0));
    }


}
