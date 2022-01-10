package toyproject.board.domain.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toyproject.board.domain.Member;
import toyproject.board.domain.Service.MemberService;


@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Test
    void 회원_가입 (){
    //given
        Member member = Member.builder()
                .username("min")
                .password("1234")
                .email("email")
                .build();
    //when

    //then
    }
}