package com.developia.mvcbasic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
