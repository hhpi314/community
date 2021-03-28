package com.community.community.mapper;

import com.community.community.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Select("select * from question limit #{offset}, #{size}")
    List<Question> list(@Param(value="offset") Integer offset, @Param(value="size") Integer size);
    //非对象类，需要用Param声明

    @Select("select count(1) from question")
    Integer count();

    //public void create(Question question);
}
