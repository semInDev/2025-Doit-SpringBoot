package com.mysite.sbb.service;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.domain.Answer;
import com.mysite.sbb.domain.Question;
import com.mysite.sbb.domain.SiteUser;
import com.mysite.sbb.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public Answer create(Question question, String content,
                       SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setQuestion(question);
        answer.setCreatedDate(LocalDateTime.now());
        answer.setAuthor(author);
        this.answerRepository.save(answer);
        return answer;
    }

    public Answer getAnswer(Integer id) {
        Optional<Answer> answer = this.answerRepository.findById(id);
        if(answer.isPresent()) {
            return answer.get();
        }
        else{
            throw new DataNotFoundException("answer not found");
        }
    }

    public void modify(Answer answer, String content) {
        answer.setContent(content);
        answer.setModifyDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }

    public void delete(Answer answer) {
        this.answerRepository.delete(answer);
    }

    public void vote(Answer answer, SiteUser user) {
        answer.getVoter().add(user);
        this.answerRepository.save(answer);
    }
}
