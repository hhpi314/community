package com.community.community.service;

import com.community.community.dto.QuestionDTO;
import com.community.community.mapper.QuestionMapper;
import com.community.community.mapper.UserMapper;
import com.community.community.model.Question;
import com.community.community.model.User;
import com.community.community.repository.QuestionRepository;
import com.community.community.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private UserRepository userRepository;

    public List<QuestionDTO> list() {
        List<Question> questionList = (List<Question>) questionRepository.findAll();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for(Question question:questionList){
            User user = userRepository.findById(question.getCreator()).get();
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
