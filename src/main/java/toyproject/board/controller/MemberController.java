package toyproject.board.controller;

import lombok.AllArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toyproject.board.dto.UpdateForm;
import toyproject.board.service.MemberService;
import toyproject.board.domain.Member;
import toyproject.board.dto.MemberDto;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/memberJoinForm")
    public String addForm() {
        return "member/memberJoinForm";
    }


    @PostMapping("/memberJoinForm")
    public String createMember(@ModelAttribute MemberDto member) {
        memberService.joinUser(member);
        return "redirect:/";
    }

    @GetMapping("/memberLoginForm")
    public String login() {
        return "member/memberLoginForm";
    }

    @GetMapping("/memberLoginResult")
    public String loginResult() {
        return "member/memberLoginResult";
    }

    @GetMapping("/memberList")
    public String findAllMember(Model model){
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "member/memberList";
    }

//    @PostMapping("{memberId}/update")
//    public String updateMemberForm(@PathVariable("memberId"), @ModelAttribute Member member){
//        memberService.updateMember(member);
//        return "redirect:/";
//    }
}
