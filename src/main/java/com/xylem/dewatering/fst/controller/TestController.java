package com.xylem.dewatering.fst.controller;
/**
 * Created by Anoop.ks on 11-12-2017
 */

import com.xylem.dewatering.fst.entity.Account;
import com.xylem.dewatering.fst.entity.dto.AccountDto;
import com.xylem.dewatering.fst.entity.embeddable.AccountAddress;
import com.xylem.dewatering.fst.service.impl.AccountServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(value = "Project Skeleton")
public class TestController extends BaseController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    AccountServiceImpl accountService;

    @ApiOperation(value = "Check Service Availability",
            notes = "This is to check the service availability",
            response = String.class,
            httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response success", response = String.class),
            @ApiResponse(code = 404, message = "Service Not Available"),
            @ApiResponse(code = 500, message = "Service Not Available")
    })
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getFullName() {
        return "Service Running Successfully";
    }


    /**
     * @apiNote API to save the Account information of a customer.
     * @implNote API integrated with swagger will have an account which is persisted in DB as response.
     * @param accountDto
     * @return Account.class
     */
    @ApiOperation(value = "To check Entity is working or not",
            response = Account.class,
            httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response success", response = Account.class),
            @ApiResponse(code = 404, message = "Service Not Available"),
            @ApiResponse(code = 500, message = "Server down")
    })
    @PostMapping(value = "/save", produces = "application/json", consumes = "application/json")
    public Account postTestData(@Valid @RequestBody AccountDto accountDto) {
        System.out.println("Account dto :: " + accountDto);
        return accountService.saveAccount(generateAccountFromDto(accountDto));
    }

    /**
     * @implNote To extract request body and create entity object.
     * @param accountDto
     * @return Account.class
     */
    private Account generateAccountFromDto(AccountDto accountDto) {

        logger.info("Creating Account object started.");
        try {
            AccountAddress accountAddress = new AccountAddress(accountDto.getAddress_line_1(),
                    accountDto.getAddress_line_2(), accountDto.getCity(), accountDto.getState(),
                    accountDto.getZip(), accountDto.getCountry());

            return new Account(accountDto.getName(), accountDto.getPhoneNumber(), accountDto.getStatus(),
                    accountDto.getEmail(), accountDto.getLocation(), accountDto.getCustomer_id(), accountAddress);
        } finally {
            logger.info("Account created and returned.");
        }
    }
}
