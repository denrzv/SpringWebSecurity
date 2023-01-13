package io.github.denrzv.springwebsecurity.repository;

import io.github.denrzv.springwebsecurity.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

@Configuration
public class RepositoryPreload {

    private static final Logger log = LoggerFactory.getLogger(RepositoryPreload.class);

    @Bean
    CommandLineRunner initDatabase(Repository repository) {
        return args -> {
            log.info("Загрузка данных в БД...");
            var names = Arrays.asList("Антон", "Иван", "Михаил");
            var surnames = Arrays.asList("Антонов", "Иванов", "Михайлов");
            var cities = Arrays.asList("Архангельск","Борисоглебск","Воронеж");
            var random = new Random();
            IntStream.range(0, 100)
                    .forEach(i -> {
                        var person = Person.builder()
                                .name(names.get(random.nextInt(names.size())))
                                .surname(surnames.get(random.nextInt(surnames.size())))
                                .age(random.nextInt(90))
                                .phoneNumber(random.nextInt())
                                .cityOfLiving(cities.get(random.nextInt(cities.size())))
                                .build();
                        repository.save(person);
                    });
        };
    }
}
