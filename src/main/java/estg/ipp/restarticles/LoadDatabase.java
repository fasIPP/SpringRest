package estg.ipp.restarticles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ArticleRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                repository.save(new Article("News 1", "News content"));
                repository.save(new Article("News 2", "More news content"));
            }
        };
    }
}
