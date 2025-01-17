package com.mysite.sbb.controller;

import com.mysite.sbb.domain.Question;
import com.mysite.sbb.dto.AnswerForm;
import com.mysite.sbb.dto.QuestionForm;
import com.mysite.sbb.repository.QuestionRepository;
import com.mysite.sbb.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("/question")//ch02-11 URL prifix 알아두기
@RequiredArgsConstructor
@Controller
public class QuestionController {

/*    //ch02-7 질문 목록 만들기
    //데이터를 템플릿에 전달하기
    //How? QuestionRepository로 데이터 조회 -> Model 클래스를 사용하여 템플릿에 전달

    @Autowired
    private QuestionRepository questionRepository;*/

    private final QuestionService questionService;


    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
/*        //ch02-7 질문 목록 만들기 => question 테이블의 데이터를 조회하고 이를 템플릿에 전달하여 화면에 출력하기
        List<Question> questions = questionRepository.findAll();
        model.addAttribute("questionList", questions);
        return "question_list";*/

        //ch02-9 서비스 만들기: 컨트롤러 -> 서비스 -> 리포지토리 순으로 접근

        //ch03-2 페이징
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    
/*
* question_form.html은 [질문 등록하기] 버튼을 통해
* GET 방식으로 URL이 요청되더라도 th:object에 의해
* QuestionForm 객체가 필요하기 때문이다.
* */
    @GetMapping("/create")
/*
    public String questionCreate() {
*/
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
/*    public String questionCreate(@RequestParam(value = "subject") String subject,
                                 @RequestParam(value = "content") String content) {*/
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";//질문 저장 후 질문 목록 페이지로 이동
    }
}
