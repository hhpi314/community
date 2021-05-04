package com.community.community.controller;

import com.community.community.dto.CommentDTO;
import com.community.community.dto.ResultDTO;
import com.community.community.exception.CustomizeErrorCode;
import com.community.community.mapper.CommentMapper;
import com.community.community.model.Comment;
import com.community.community.model.User;
import com.community.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO, HttpServletRequest request){//会将接收到的json格式数据，赋值到commentDTO中
        User user = (User) request.getSession().getAttribute("user");//从session中获取user
        if (user == null) {//user未登录
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);//为什么返回这个
        }
        Comment comment=new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setParentId(commentDTO.getParentId());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
