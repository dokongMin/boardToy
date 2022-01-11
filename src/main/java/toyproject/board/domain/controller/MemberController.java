package toyproject.board.domain.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import toyproject.board.domain.Service.MemberService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("boardForm")
    public String boardForm(){
        return "boardForm";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("board")
    public String board(){
        return "board";
    }
}
