package toyproject.board.domain.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;
import toyproject.board.domain.Member;
import toyproject.board.domain.Service.MemberService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;


    @Test
    void 회원_가입(){
    //given
        Member member = Member.builder()
                .username("mi")
                .password("1234")
                .email("email")
                .build();
    //when
        memberService.join(member);
    //then
        Assertions.assertThat(member).isEqualTo(memberService.findOne(member.getId()));
    }

    @Test
    void 중복_회원_가입 (){
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
        assertThrows(IllegalStateException.class , () -> memberService.join(member2));
    }
}