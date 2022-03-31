package toyproject.board.controller;

import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toyproject.board.domain.Member;
import toyproject.board.dto.MemberDto;
import toyproject.board.service.MemberService;

import java.util.List;

@Controller
@AllArgsConstructor
@ApiResponses({
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/memberJoinForm")
    public String addForm() {
        return "member/memberJoinForm";
    }


    //    @ApiOperation(value = "Post 통신", notes = "Post 통신 Note", response = String.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 404, message = "페이지 없음"),
//            @ApiResponse(code = 500, message = "서버 에러")
//    })
    @ApiOperation(value = "저장", notes = "테스트입니다")
    @PostMapping("/memberJoinForm")
    public String createMember(@ModelAttribute MemberDto member) {
        memberService.joinUser(member);
//        return result;
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
    public String findAllMember(Model model) {
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
