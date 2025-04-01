package com.baki.jpaproject;

import static org.junit.jupiter.api.Assertions.*;

import com.baki.jpaproject.domain.Member;
import com.baki.jpaproject.service.MemberService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception{

        //Given
        Member member = new Member();
        member.setName("Park");

        //When
        Long saveId = memberService.join(member);

        //then
        assertEquals(member,memberRepository.findOne(saveId));
    }
    @Test
    public void 중복회원예외() throws Exception{
        //Given
        Member member = new Member();
        member.setName("Park");

        Member member2 = new Member();
        member2.setName("Park");

        //When
        memberService.join(member);

        //than
        assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });
    }
}
