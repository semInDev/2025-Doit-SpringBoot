package com.mysite.sbb.controller;

import com.mysite.sbb.domain.Question;
import com.mysite.sbb.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {
    //데이터를 템플릿에 전달하기
    //How? QuestionRepository로 데이터 조회 -> Model 클래스를 사용하여 템플릿에 전달
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/question/list")
    public String list(Model model) {
        List<Question> questions = questionRepository.findAll();
        model.addAttribute("questionList", questions);
        return "question_list";
    }
}
