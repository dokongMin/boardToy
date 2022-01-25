package toyproject.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//(exclude = SecurityAutoConfiguration.class )
@SpringBootApplication(exclude={MultipartAutoConfiguration.class})
@EnableJpaAuditing
public class BoardApplication {


	public static void main(String[] args) {



		SpringApplication.run(BoardApplication.class, args);
	}

}
