package com.developia.mvcbasic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        // 템플릿 뷰 엔진에서 파싱하여 보여줄수 있다.
        // viewResolver가 화면을 알아서 찾아서 처리함
        // resources:templates/ +{ViewName}+ .html
        model.addAttribute("data", "hello");
        return "hello";
    }

    // template 방식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // api 방식 - 문자열 방식
    // api 방식은 viewResolver 대신 HttpMessageConverter가 작동
    // Http Accept Header와 컨트롤러 반환 타입들을 조합해서 결정됨(기본 문자인지 객체인지)
    // 기본 문자 처리 StringHttpMessageConverter
    @GetMapping("hello-spring")
    @ResponseBody
    public String helloString(@RequestParam("name") String name, Model model) {
        return "hello " + name;
    }

    // api 방식 - 객체 방식 (json)
    // 기본 객체 처리 MappingJackson2HttpMessageConverter
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
