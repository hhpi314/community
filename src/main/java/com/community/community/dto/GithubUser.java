package com.community.community.dto;

import lombok.Data;

@Data
public class GithubUser {
    //命名要与github的命名一样
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
