package com.mysite.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello2() {//url과 메서드 명이 달라고 괜찮음!(p.36)
        return "Hello SSB";
        //return "Hello World";서버 실행 중에 내용을 바꾸면 수정이 안 됨
        // -> Devtools 필요!
    }
}
