package toyproject.board.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import toyproject.board.domain.Member;

@Getter
@Setter
@NoArgsConstructor
@ApiModel
public class MemberDto {

    @ApiParam(value = "id", example = "1")
    private Long id;
    @ApiParam(value = "username", example = "u")
    private String username;
    @ApiParam(value = "password", example = "p")
    private String password;
    @ApiParam(value = "email", example = "e")
    private String email;

    @Builder
    public MemberDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Member toEntity(){
        return Member.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
    }
}
