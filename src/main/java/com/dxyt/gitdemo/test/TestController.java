package com.dxyt.gitdemo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class TestController {
    
    /**
     * 方法名称：testGit
     * 方法描述：
     * 创建人：安红飞（anhongfei@telecomyt.com.cn）
     * 创建时间：2018/10/10 10:53 
     * 修改人：安红飞（anhongfei@telecomyt.com.cn）
     * 修改时间：2018/10/10 10:53
     * 修改备注：
     * 方法参数： []
     * 方法返回值： java.lang.String
     **/
    
    @RequestMapping("/testGit")
    public String testGit(){
        System.out.println("安红地方");
        System.out.println("dfdf");
        System.out.println("dfgfrewtgf");
        System.out.println("dfdsdfsdf");
        System.out.println("rtretger");
        return "";
    }
    
    /**
     * 方法名称：testGit2
     * 方法描述：
     *
     * comyt.com.cn）
     * 创建时间：2018/10/10 10:52
     * 修改人：安红飞（anhongfei@telecomyt.com.cn）
     * 修改时间：2018/10/10 10:52
     * 修改备注：
     * 方法参数： [str]
     * 方法返回值： java.lang.String
     **/
    @RequestMapping("/testGit2")
    public String testGit2(String str){
        System.out.println("安红");
        System.out.println("dfdf");
        System.out.println("dfgfrewtgf");
        System.out.println("dfdsdfsdf");
        System.out.println("测试提交冲突");
        System.out.println("测试提交");
        System.out.println("同一行的冲突");
        System.out.println("测试提交");
        System.out.println("同一行的");
        System.out.println("rtretger");
        System.out.println("rtretger");
        System.out.println("rtretger");
        System.out.println("rtretger");
        return "";
    }

    /**
     * 方法名称：testAn
     * 方法描述：
     * 创建人：安红飞（anhongfei@telecomyt.com.cn）
     * 创建时间：2018/10/11 13:25
     * 修改人：安红飞（anhongfei@telecomyt.com.cn）
     * 修改时间：2018/10/11 13:25
     * 修改备注：
     * 入参: str
     * 入参: id
     * 入参: date
     * 返回值类型： java.lang.Integer
     **/
    public Integer testAn(String str, Integer id, Date date){

        return null;
    }

}
