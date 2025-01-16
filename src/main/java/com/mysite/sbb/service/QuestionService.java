package com.mysite.sbb.service;

import com.mysite.sbb.domain.Question;
import com.mysite.sbb.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    //@RequiredArgsConstructor으로 의존성 주입

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }
}
