package com.anpjavatech.project_skelton.controller;
/**
 * Created by Anoop.ks on 11-12-2017
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController extends BaseController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getFullName() {
        return "Service Running Successfully";
    }

}
