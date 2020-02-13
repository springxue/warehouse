package com.casic.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "views/index";
    }
    /**
     * 跳转控制台方法
     * @return
     */
    @RequestMapping("/toConsole")
    public String toConsole(){
        return "views/home/console";

    }
}
