package toyproject.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.board.domain.Board;
import toyproject.board.dto.BoardDto;
import toyproject.board.repository.BoardRepository;
import toyproject.board.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long saveBoard(BoardDto boardDto){
        boardRepository.save(boardDto.toEntity());
        return boardDto.getId();
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }
}
