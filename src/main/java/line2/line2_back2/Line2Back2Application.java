package line2.line2_back2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Line2Back2Application {

    public static void main(String[] args) {
        SpringApplication.run(Line2Back2Application.class, args);
    }

}
