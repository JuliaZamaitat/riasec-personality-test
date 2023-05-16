package riasec.backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = { "riasec.backend", "riasec.backend.model.classes" })public class RiasecTestBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(RiasecTestBackendApplication.class, args);
	}

}
