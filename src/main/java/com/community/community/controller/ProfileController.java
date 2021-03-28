package com.community.community.controller;

import com.community.community.dto.PaginationDTO;
import com.community.community.model.User;
import com.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/profile/{action}")//希望调用profile的时候，进行的操作
    public String profile(@PathVariable(name = "action")String action,  //动态路径
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(name="page",defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "5")Integer size){
        User user = (User) request.getSession().getAttribute("user");//直接session中获取user
        if(user==null)return "redirect:/";//用户未登录，返回首页

        if(action.contentEquals("questions")){//问题列表
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName","问题列表");
        }
        else if(action.contentEquals("replies")){//回复
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName","最新回复");
        }
        PaginationDTO paginationDTO = questionService.list(user.getId(),page,size);
        model.addAttribute("pagination",paginationDTO);
        return "profile";//返回页面
    }
}
