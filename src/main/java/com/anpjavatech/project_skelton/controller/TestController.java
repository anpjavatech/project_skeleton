package com.anpjavatech.project_skelton.controller;
/**
 * Created by Anoop.ks on 11-12-2017
 */
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Project Skeleton",description = "Project Skeleton")
public class TestController extends BaseController {

    @ApiOperation(value = "Check Service Availability",
            notes = "This is to check the service availability",
            response = String.class,
            httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response success", response = String.class),
            @ApiResponse(code = 404,message = "Service Not Available"),
            @ApiResponse(code=500,message = "Service Not Available")
    })
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getFullName() {
        return "Service Running Successfully";
    }

}
