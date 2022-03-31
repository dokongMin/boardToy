package toyproject.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.board.domain.Board;
import toyproject.board.dto.BoardDto;
import toyproject.board.repository.BoardRepository;
import toyproject.board.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long saveBoard(BoardDto boardDto){
        boardRepository.save(boardDto.toEntity());
        return boardDto.getId();
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    @Transactional
    public Page<Board> getBoardList(Pageable pageable) {

        return boardRepository.findAll(pageable);

    }

    public Page<Board> paging(int page) {
        return boardRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id")));

    }
//    public List<BoardDto> paging(int pageNum){
//        Page<Board> page = boardRepository.findAll(PageRequest.of(pageNum - 1, 10, Sort.by(Sort.Direction.DESC, "id")));
//
//        List<Board> boards = page.getContent();
//        List<BoardDto> boardDtoList = new ArrayList<>();
//
//        for (BoardDto boardDto : boardDtoList) {
//            boardDto
//        }
//        return
//    }

}
