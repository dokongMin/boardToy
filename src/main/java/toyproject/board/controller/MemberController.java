package toyproject.board.controller;

import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toyproject.board.domain.Member;
import toyproject.board.dto.MemberDto;
import toyproject.board.service.MemberService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
@Api(value = "BoardController V1")
@RequestMapping("/member")
public class MemberController {

    @ApiOperation(value = "test", notes = "테스트입니다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "page not found!")
    })
    @GetMapping(value = "/memberJoinForm")
    public Map<String, String> selectBoard(
            @ApiParam(value = "이름", required = true) @RequestParam(required = true, defaultValue = " ") String param1,
            @ApiParam(value = "회원번호", required = true) @RequestParam(required = true, defaultValue = "0") int param2,
            @ApiParam(value = "비밀번호", required = true) @RequestParam(required = true, defaultValue = " ") String param3,
            @ApiParam(value = "이메일", required = true) @RequestParam(required = true, defaultValue = " ") String param4
    ) {

        Map<String, String> result = new HashMap<>();
        result.put("test", "테스트");
        result.put("test contents", "테스트 내용");
        return  result;
    }
    private final MemberService memberService;

    @GetMapping("/memberJoinForm")
    public String addForm() {
        return "member/memberJoinForm";
    }



    @PostMapping("/memberJoinForm")
    public String createMember(@ModelAttribute MemberDto member){
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
