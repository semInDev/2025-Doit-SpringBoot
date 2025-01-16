package com.mysite.sbb.service;

import com.mysite.sbb.domain.Answer;
import com.mysite.sbb.domain.Question;
import com.mysite.sbb.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setQuestion(question);
        answer.setCreatedDate(LocalDateTime.now());
        answerRepository.save(answer);
    }
}
