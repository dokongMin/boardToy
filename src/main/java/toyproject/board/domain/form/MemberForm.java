package toyproject.board.domain.form;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberForm {

    private String username;
    private String password;
    private String email;

    @Builder
    public MemberForm(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
