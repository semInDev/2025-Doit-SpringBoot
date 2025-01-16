package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter//RequiredArgsConstructor 사용->final 사용->set불가!, 따라서 생성자애너테이션 사용 시 Setter는 필요 없음!
@RequiredArgsConstructor
public class HelloLombok {
/*    private String hello;
    private int lombok;*/
    private final String hello;//RequiredArgsConstructor 사용하려면 final 필요
    private final int lombok;

    public static void main(String[] args) {
/*        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setHello("헬로");
        helloLombok.setLombok(5);*/
        HelloLombok helloLombok = new HelloLombok("헬로", 5);

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}
