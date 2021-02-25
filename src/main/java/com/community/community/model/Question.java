package com.community.community.model;

import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
