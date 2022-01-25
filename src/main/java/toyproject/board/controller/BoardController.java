package toyproject.board.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import toyproject.board.domain.Board;
import toyproject.board.dto.BoardDto;
import toyproject.board.dto.MemberDto;
import toyproject.board.repository.BoardRepository;
import toyproject.board.service.BoardService;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

//    @GetMapping("/boardIndex")
//    public String boardIndex(){
//        return "/board/boardIndex";
//    }


    @GetMapping("/boardForm")
    public String addBoard(){
        return "/board/boardForm";
    }

    @PostMapping("/boardForm")
    public String createBoard(@ModelAttribute BoardDto boardDto){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails)principal;
        String username = userDetails.getUsername();

//        String createdBy = (String) session.getAttribute("username");
        boardDto.setCreatedBy(username);
        boardService.saveBoard(boardDto);
        return "redirect:/board/boardIndex";
    }

    @GetMapping("/boardIndex")
    public String boardList(Model model){
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "board/boardIndex";
    }
}
