package toyproject.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import toyproject.board.domain.Member;
import toyproject.board.domain.Service.MemberService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/memberLoginForm")
    public String login() {
        return "member/memberLoginForm";
    }

    @GetMapping("/memberJoinForm")
    public String addForm() {
        return "member/memberJoinForm";
    }


    @PostMapping("/memberJoinForm")
    public String createMember(@ModelAttribute Member member){
        memberService.join(member);
        return "member/memberSaved";
    }


}
//    @PostMapping("/memberJoinForm")
//    public String createMember(Member member, RedirectAttributes redirectAttributes) {
//        Long savedMember = memberService.join(member);
//        redirectAttributes.addAttribute("memberId", savedMember);
//        redirectAttributes.addAttribute("status", true);
//        return "member/memberSaved";
//    }