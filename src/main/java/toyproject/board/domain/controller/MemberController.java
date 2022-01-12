package toyproject.board.domain.controller;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toyproject.board.domain.Member;
import toyproject.board.domain.Service.MemberService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("memberJoinForm")
    public String addForm(){
        return "memberJoinForm";
    }

    @PostMapping("memberJoinForm")
    public String createMember(@ModelAttribute Member member){
//        Member member = Member.builder()
//                .username(username)
//                .password(password)
//                .email(email)
//                .build();
        memberService.join(member);
        return "memberJoinForm";
    }
    @GetMapping("joinMember")
    public String joinMember(){
        return "joinMember";
    }

    @GetMapping("boardForm")
    public String boardForm(){
        return "boardForm";
    }

    @GetMapping("board")
    public String board(){
        return "board";
    }
}
