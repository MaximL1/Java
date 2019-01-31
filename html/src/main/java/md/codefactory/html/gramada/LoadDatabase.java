package md.codefactory.html.gramada;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(UsersRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User("Ion", "chiler")));
            log.info("Preloading " + repository.save(new User("Andrei", "politist")));
        };
    }
}
