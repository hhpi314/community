package com.community.community.mapper;

import com.community.community.model.Question;

public interface QuestionExtMapper {
    void incView(Question question);

    void incCommentCount(Question question);
}
