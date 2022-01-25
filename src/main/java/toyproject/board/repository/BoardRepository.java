package toyproject.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toyproject.board.domain.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
        List<Board> findAll();

}
