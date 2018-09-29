package com.dxyt.gitdemo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/testGit")
    public String testGit(){
        System.out.println("安红飞");
        System.out.println("dfdf");
        return "";
    }

}
