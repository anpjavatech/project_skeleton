package com.xylem.dewatering.fst.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xylem.dewatering.fst.FstApplication;
import com.xylem.dewatering.fst.entity.Account;
import com.xylem.dewatering.fst.entity.dto.AccountDto;
import com.xylem.dewatering.fst.entity.embeddable.AccountAddress;
import com.xylem.dewatering.fst.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Anoop.ks on 20-12-2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = FstApplication.class)
@AutoConfigureMockMvc
@Transactional
public class AccountControllerIntegrationTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    AccountRepository accountRepository;

    @Test
    @Rollback
    public void testAccountController() throws Exception {

        mvc.perform(post("/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(createAccountDtoObj())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print());
    }


    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Account createAccountObj() {
        return new Account("Anoop", "8971983387", "Active", "anoop.ks007@gmail.com",
                "Bangalore", "jhgkhjh", new AccountAddress("hbkj", "kjklk",
                "kjnj", "lkljkk", "lkljk", "lkmkk"));
    }

    private AccountDto createAccountDtoObj() {
        return new AccountDto("Anoop", "8971983387", "Active", "anoop.ks007@gmail.com",
                "Bangalore", "jhgkhjh", "hbkj", "kjklk",
                "kjnj", "lkljkk", "lkljk", "lkmkk");
    }

}
