package com.community.community.controller;

import com.community.community.dto.QuestionDTO;
import com.community.community.mapper.QuestionMapper;
import com.community.community.mapper.UserMapper;
import com.community.community.model.Question;
import com.community.community.model.User;
import com.community.community.repository.QuestionRepository;
import com.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class indexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model ){
        Cookie[] cookies = request.getCookies();
        if(cookies==null)return "index";//先判断网页中存不存在cookies
        for(Cookie cookie: cookies){//遍历cookies
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if(user!=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        List<QuestionDTO> questionList =  questionService.list();//数据库中提取所有问题
        model.addAttribute("questions",questionList);
        return "index";
    }

}
