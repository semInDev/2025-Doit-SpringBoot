package com.mysite.sbb.repository;

import com.mysite.sbb.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.security.auth.Subject;
import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
}
