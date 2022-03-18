package com.pedrolsoares.itbootcampw5spring;

import com.pedrolsoares.itbootcampw5spring.sports.model.Athlete;
import com.pedrolsoares.itbootcampw5spring.sports.model.Person;
import com.pedrolsoares.itbootcampw5spring.sports.model.Sport;
import com.pedrolsoares.itbootcampw5spring.sports.repository.AthleteRepository;
import com.pedrolsoares.itbootcampw5spring.sports.repository.PersonRepository;
import com.pedrolsoares.itbootcampw5spring.sports.repository.SportsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ItBootcampW5SpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItBootcampW5SpringApplication.class, args);

        SportsRepository sportsRepository = new SportsRepository();
        PersonRepository personRepository = new PersonRepository();
        AthleteRepository athleteRepository = new AthleteRepository();

        Sport s1 = new Sport("Basquete", 4);
        sportsRepository.insertMany(
                List.of(
                        s1,
                        new Sport("Futebol", 5),
                        new Sport("Golf", 2)

                )
        );
        Person p1 = new Person("Pedro", "Levada", 22);
        personRepository.insertMany(
                List.of(
                        p1,
                        new Person("Jonas", "Silva", 33)
                )
        );

        athleteRepository.insertOne(new Athlete(p1, s1));
    }

}
