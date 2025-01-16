package com.mysite.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    //404에러는 url과 컨트롤러 메서드를 매핑 안 했거나 템플릿을 못 찾았을 때!
    //500에러는 해당 메서드에 return이 없을 때
    @GetMapping("/sbb")
    @ResponseBody
    public String index(){
        return "안녕하세요 SBB에 오신 것을 환영합니다.";
    }

    //루트 URL 만들기
    @GetMapping("/")
    public String root(){
        return "redirect:/question/list";
        //리다이렉트할 URL 입력(localhost:8080으로 접속하면 자동으로 /question/list으로 이동함)
    }
}
