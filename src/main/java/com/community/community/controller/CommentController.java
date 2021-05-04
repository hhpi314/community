package com.community.community.controller;

import com.community.community.dto.CommentDTO;
import com.community.community.mapper.CommentMapper;
import com.community.community.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;
    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO){//会将接收到的json格式数据，赋值到commentDTO中
        Comment comment=new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setParentId(commentDTO.getParentId());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        comment.setCommentator(1);
        comment.setLikeCount(0L);
        commentMapper.insert(comment);
        return null;
    }
}
