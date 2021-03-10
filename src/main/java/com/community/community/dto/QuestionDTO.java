package com.community.community.dto;

import com.community.community.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Long id;
    private String title;//标题
    private String description;//描述
    private String tag;//标签
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;//创建者id
    private Integer viewCount=0;//浏览数
    private Integer commentCount=0;//评论数
    private Integer likeCount=0;//点赞数
    private User user;
}
