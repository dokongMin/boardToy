package toyproject.board.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toyproject.board.domain.Board;

@Data
@NoArgsConstructor
public class BoardDto {

    private Long id;
    private String title;
    private String content;
    private String createdBy;

    @Builder
    public BoardDto(String title, String content, String createdBy) {
        this.title = title;
        this.content = content;
        this.createdBy = createdBy;
    }

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .createdBy(createdBy)
                .build();
    }
}
