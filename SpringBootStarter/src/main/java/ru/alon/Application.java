package ru.alon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.alon.entity.Jedi;
import ru.alon.repository.JediRepository;


@SpringBootApplication
@EnableJpaRepositories(value = "ru.alon.repository")
@EntityScan("ru.alon.entity")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(JediRepository repository) {
        return (args) -> {
            repository.save(Jedi.builder().firstName("first").lastName("last").build());
            for (Jedi jedi :
                    repository.findAll()) {
                System.out.println(jedi);
            }
        };
    }
}
