package toyproject.board.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Getter
public class Board extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;
    private String title;
    private String content;
    private String createdBy;
    private Long countVisit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 외래키를 설정
    private Member member;

    public void setMember(Member member){
        this.member = member;
        member.getBoard().add(this);
    }

    @Builder
    public Board(String title, String content, String createdBy,Long countVisit) {
        this.title = title;
        this.content = content;
        this.createdBy = createdBy;
        this.countVisit = countVisit;
    }

    protected Board(){}
}
