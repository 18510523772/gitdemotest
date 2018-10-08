package com.dxyt.gitdemo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/testGit")
    public String testGit(){
        System.out.println("安红地方");
        System.out.println("dfdf");

        System.out.println("dfgfrewtgf");


        System.out.println("dfdsdfsdf");
        System.out.println("rtretger");
        return "";
    }

    @RequestMapping("/testGit2")
    public String testGit(String str){
        System.out.println("安红");
        System.out.println("dfdf");
        System.out.println("dfgfrewtgf");
        System.out.println("dfdsdfsdf");
        System.out.println("测试提交冲突");
        System.out.println("测试提交");
        System.out.println("同一行");
        System.out.println("rtretger");
        System.out.println("rtretger");
        System.out.println("rtretger");
        System.out.println("rtretger");
        return "";
    }

}
