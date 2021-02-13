package com.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //允许类接受前端的请求
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name")String name, Model model){//提示参数快捷键ctrl+p
        model.addAttribute("name",name);
        return "hello"; //会自动去templates下找hello模板
    }

}
