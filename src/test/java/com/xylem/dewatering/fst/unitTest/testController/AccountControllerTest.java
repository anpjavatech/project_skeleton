package com.xylem.dewatering.fst.unitTest.testController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xylem.dewatering.fst.controller.TestController;
import com.xylem.dewatering.fst.entity.Account;
import com.xylem.dewatering.fst.entity.dto.AccountDto;
import com.xylem.dewatering.fst.entity.embeddable.AccountAddress;
import com.xylem.dewatering.fst.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Anoop.ks on 20-12-2017
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AccountServiceImpl accountService;

    @Test
    public void testControllerForPost() throws Exception {

        given(accountService.saveAccount(createAccountObj())).willReturn(createAccountObj());
        mvc.perform(post("/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(createAccountDtoObj())))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());

    }

    @Test
    public void testControllerForGet() throws Exception {

        mvc.perform(get("/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
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

