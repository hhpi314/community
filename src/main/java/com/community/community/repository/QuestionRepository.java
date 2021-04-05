package com.community.community.repository;

import com.community.community.model.Question;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called QuestionRepository
// CRUD refers Create, Read, Update, Delete
public interface QuestionRepository extends CrudRepository<Question, Long> {

}
