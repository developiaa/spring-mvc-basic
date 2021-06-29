package com.developia.mvcbasic;

import com.developia.mvcbasic.repository.MemberRepository;
import com.developia.mvcbasic.repository.MemoryMemberRepository;
import com.developia.mvcbasic.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 직접 스프링 빈 객체로 등록하는 방법, @Service, @Repository와 동일
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
