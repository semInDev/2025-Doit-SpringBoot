package com.mysite.sbb.controller;

import com.mysite.sbb.domain.Question;
import com.mysite.sbb.repository.QuestionRepository;
import com.mysite.sbb.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

/*    //ch02-7 질문 목록 만들기
    //데이터를 템플릿에 전달하기
    //How? QuestionRepository로 데이터 조회 -> Model 클래스를 사용하여 템플릿에 전달

    @Autowired
    private QuestionRepository questionRepository;*/

    private final QuestionService questionService;


    @GetMapping("/question/list")
    public String list(Model model) {
/*        //ch02-7 질문 목록 만들기 => question 테이블의 데이터를 조회하고 이를 템플릿에 전달하여 화면에 출력하기
        List<Question> questions = questionRepository.findAll();
        model.addAttribute("questionList", questions);
        return "question_list";*/

        //ch02-9 서비스 만들기: 컨트롤러 -> 서비스 -> 리포지토리 순으로 접근
        List<Question> questions = this.questionService.getList();
        model.addAttribute("questionList", questions);
        return "question_list";
    }

    @GetMapping("/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

}
