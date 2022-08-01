package toyproject.board.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    //    @NotBlank(message = "아이디를 입력해주세요.")
//    @Pattern(regexp = "^[a-zA-Z0-9]{3,12}$", message = "아이디를 3~12자로 입력해주세요. [특수문자 X]")
    @Column
    private String username;
    //    @NotBlank(message = "비밀번호를 입력해주세요.")
//    @Pattern(regexp = "^[a-zA-Z0-9]{3,12}$", message = "비밀번호를 3~12자로 입력해주세요.")
    @Column
    private String password;
    @Column
    private String email;
    private String provider;
    private String providerId;

//    @Enumerated(EnumType.STRING)
    private String role;
//    private String roles;

    @OneToMany(mappedBy = "member") // 주인 필드 명
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<BoardComment> boardCommentList = new ArrayList<>();

    @Builder
    public Member(String username, String password, String email, List<Board> boardList, List<BoardComment> boardCommentList, String role, String provider, String providerId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.boardList = boardList;
        this.boardCommentList = boardCommentList;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }

    public Member update(String username){
        this.username = username;
        return this;
    }
//    public String getRoleKey(){
//        return this.role.getKey();
//    }
//
//    public String getRoleValue(){
//        return this.role.getValue();
//    }

}
