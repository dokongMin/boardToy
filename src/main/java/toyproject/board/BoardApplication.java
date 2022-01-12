package toyproject.board;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import toyproject.board.domain.Member;
import toyproject.board.domain.Service.MemberService;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class )
public class BoardApplication {


	public static void main(String[] args) {



		SpringApplication.run(BoardApplication.class, args);
	}

}
