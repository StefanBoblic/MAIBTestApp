package md.maib.app.maib;

import md.maib.app.maib.json.JsonReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class MaibApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaibApplication.class, args);
    }
}
