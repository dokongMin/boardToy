package toyproject.board.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import toyproject.board.domain.Member;
import toyproject.board.domain.Repository.MemberRepository;
import toyproject.board.domain.Service.MemberService;

import javax.swing.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest


class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원_가입() {
        //given
        Member member = Member.builder()
                .username("mins")
                .password("1234")
                .email("email")
                .build();
        //when
        Long joinId = memberService.join(member);
        //then
        Assertions.assertEquals(member, memberRepository.findOne(joinId));
    }

    @Test
    @Rollback
    void 중복_회원_가입() {
        //given
        Member member = Member.builder()
                .username("min")
                .password("1234")
                .email("email")
                .build();

        Member member2 = Member.builder()
                .username("min")
                .password("1234")
                .email("email")
                .build();
        //when
        memberService.join(member);
        //then
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }

}